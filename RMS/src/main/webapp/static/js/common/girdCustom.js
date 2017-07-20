function GirdCustom(submitEl, cancelEl, delEl, addEl, editEl, templateEl, objects, submitUrl) {
	this.submitEl = submitEl;
	this.delEl = delEl;
	this.cancelEl = cancelEl;
	this.addEl = addEl;
	this.editEl = editEl;
	this.templateEl = templateEl;
	this.objects = objects;
	this.submitUrl = submitUrl;
	this.currentRequest = null;
}

/**
 * constructor
 */
GirdCustom.prototype.constructor = function(validateDataFunc, getObjectFunc) {
	this.deleteItem();
	this.submitChanges();
	this.cancelChanges();
	this.addMoreItem();
	this.focusout();
	this.dataChanges(validateDataFunc);
	this.getObjectFunc = getObjectFunc;
}

GirdCustom.prototype.deleteItem = function() {
	var that = this;
	$(document).on('click', this.delEl, function() {
		var id = $(this).attr('data-id');
		var par = $(this).parent().parent(); // this line
		var message = '<div><h6>' + MSG_DELETE + '</h6></div>'
		$('<div></div>').appendTo('body').html(message).dialog({
			modal : true,
			title : 'confirm',
			zIndex : 10000,
			autoOpen : true,
			width : 'auto',
			resizable : false,
			buttons : {
				Yes : function() {
					par.remove();
					$(this).dialog("close");
					that.addObjectToList(id, DELETE_TYPE);
				},
				No : function() {
					$(this).dialog("close");
				}
			},
			close : function(event, ui) {
				$(this).remove();
			}
		});
	});
}

/**
 * Click on add button
 */
GirdCustom.prototype.addMoreItem = function() {
	var that = this;
	$(document).on('click', this.addEl, function() {
		var check = that.allowAddingNew();
		if (check) { // Allow to add
			var randomId = 'new-' + Math.floor((Math.random() * 1000) + 1);
			;
			var html = $(that.templateEl).html(function(index, html) {
				html = html.replace(/##random##/g, randomId);
				$('#table-js tbody').prepend('<tr id="object-' + randomId + '">' + html + '</tr>');
			});
		} else { // Not allow to add
			showShortToast("error", MSG_COMPLETE_PREVIOUS);
		}
	});
}

/**
 * Add objects
 */
GirdCustom.prototype.addObjectToList = function(id, type)
{
	var obj = this.getObjectFunc(id);
	obj.type = type;
	switch (obj.type) {
		case DELETE_TYPE:
			if ( obj.id.indexOf('new-') >= 0) { // If remove new item
				var length = this.objects.length;
				for (var i = 0; i< length; i++) {
					if (this.gird.objects[i].id == obj.id) {
						this.gird.objects.splice(i, 1);
						break;
					}
				}
			} else { // Remove existing 
				this.objects.push(obj);
			}
			break;
		case ADD_TYPE:
			var length = this.objects.length;
			var check = false;
			for (var i = 0; i< length; i++) {
				if (this.objects[i].id == obj.id) { // Update
					this.objects.splice(i, 1);
					this.objects.push(obj);
					check = true;
				}
			}
			if (!check) { // Add new
				this.objects.push(obj);
			}
			
			break;
		default:
			breakk
	}
}

/**
 * Focus out of the input
 */
GirdCustom.prototype.focusout = function() {
	var that = this;
	$(document).on('focus', '.update-mode', function() {
		$(this).addClass('focus');
		$(this).removeClass('warning');
	});

	$(document).on('focusout', '.update-mode', function() {
		$(this).removeClass('focus');
	});
}

GirdCustom.prototype.dataChanges = function(validateData) {
	var that = this;
	$(document).on('change', '.update-mode', function() {
		if ($(this).val() != '') {
			var id = $(this).attr('data-id');
			var fieldName = $(this).attr('name');
			var value = $(this).val();
			var check = validateData(id, fieldName, value);
			if (check.status) { // Add or update list
				that.addObjectToList(id, ADD_TYPE);
			} else {
				$(this).addClass('warning');
				showShortToast("error", check.msg);
			}
		} else {
			$(this).addClass('warning');
			showShortToast("error", MSG_INPUT_REQUIRED);
		}
		console.log(that.objects);
	});
}

/**
 * Submit changes
 */
GirdCustom.prototype.submitChanges = function() {
	var that = this;
	$(document).on('click', this.submitEl, function() {
		if (that.currentRequest) {
			that.currentRequest.abort();
		} else if (that.objects && that.objects.length) {
			var check = that.validateDataBeforeSubmit();
			if (check) {
				that.currentRequest = $.ajax({
					type : "POST",
					contentType : "application/json",
					url : that.submitUrl,
					data : JSON.stringify(that.objects),
					dataType : 'text',
					success : function(rep) {
						that.objects = [];
						toastr.clear();
						showShortToast("success", MSG_UPDATE_SUCCESS);
						parent.history.back();
					},
					error : function(e) {
						if (!that.currentRequest) {
							toastr.clear();
							showShortToast("error", MSG_UPDATE_FAIL);
						}
					},

				});
			} else {
				showShortToast("error", MSG_INVALID_DATA);
			}
		} else {
			var check = that.validateDataBeforeSubmit();
		}
	});
}


/**
 * Check add new
 */
GirdCustom.prototype.allowAddingNew = function()
{
	var bool = true;
	$('.update-mode-new-line').not($('.new-line .update-mode-new-line')).each(function() {
		if ($(this).val() == '') {
			$(this).addClass('warning');
			bool = false;
		}
	});
	return bool;
}

GirdCustom.prototype.validateDataBeforeSubmit = function() {
	var ids = [];
	$('.update-mode').not($('.new-line .update-mode')).each(function() {
		if ($(this).val() == '') {
			ids.push($(this).attr('data-id'));
			$(this).addClass('warning');
		}
	});
	if (ids.length > 0) {
		return false;
	}
	return true;
}

/**
 * Cancel changes
 */
GirdCustom.prototype.cancelChanges = function() {
	var that = this;
	$(document).on('click', this.cancelEl, function() {
		if (that.objects && that.objects.length) {
			var par = $(this).parent().parent();
			var message = '<div><h6> ' + MSG_CANCEL + '</h6></div>';
			$('<div></div>').appendTo('body').html(message).dialog({
				modal : true,
				title : 'confirm',
				zIndex : 10000,
				autoOpen : true,
				width : 'auto',
				resizable : false,
				buttons : {
					Yes : function() {
						that.objects = [];
						parent.history.back();
						$(this).dialog("close");
					},
					No : function() {
						$(this).dialog("close");
					}
				},
				close : function(event, ui) {
					$(this).remove();
				}
			});
		} else {
			parent.history.back();
		}
	});
}
