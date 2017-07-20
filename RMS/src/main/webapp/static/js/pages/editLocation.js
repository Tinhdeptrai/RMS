$(document).ready(
		function() {
			var home = $('#homePath').val();
			var listLocation = [];

			$(document).on(
					'click',
					'.btn-location-delete',
					function() {
						var id = $(this).attr('data-id');
						var locationName = $(this).attr('data-locationname');
						var location = {}
						var par = $(this).parent().parent();
						$('<div></div>').appendTo('body').html(
								'<div><h6>' + MSG_DELETE + ' '
										+ locationName + ' </h6></div>')
								.dialog({
									modal : true,
									title : 'confirm',
									zIndex : 10000,
									autoOpen : true,
									width : 'auto',
									resizable : false,
									buttons : {
										Yes : function() {
											doFunctionForYes(locationName);
											par.remove();
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

						function doFunctionForYes(locationName) {
							location.locationname = locationName;
							location.id = id;
							location.type = type_delete;
							listLocation.push(location);
						}
					});

			$(document).on('click', '#btn-location-finish', function() {

				if (currentRequest) {
					currentRequest.abort();
				}
				if (listLocation && listLocation.length) {
					currentRequest = $.ajax({
						type : "POST",
						contentType : "application/json",
						url : "update-course",
						data : JSON.stringify(listLocation),
						dataType : 'text',
						timeout : timeoutAjax,
						success : function(rep) {
							listLocation = [];
							toastr.clear();
							showShortToast("success", MSG_UPDATE_SUCCESS);
							parent.history.back();
						},
						error : function(e) {
							console.log("ERROR: ", e);
							if (!currentRequest) {
								toastr.clear();
								showShortToast("error", message_update_fail);
							}
						},

					});
				} else {
					parent.history.back();
				}
			});
			$(document).on(
					'click',
					'#btn-location-cancel',
					function() {
						if (listLocation && listLocation.length) {
							var par = $(this).parent().parent();
							$('<div></div>').appendTo('body').html(
									'<div><h6> ' + MSG_CANCEL
											+ '</h6></div>').dialog({
								modal : true,
								title : 'confirm',
								zIndex : 10000,
								autoOpen : true,
								width : 'auto',
								resizable : false,
								buttons : {
									Yes : function() {
										listLocation = [];
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
		});
