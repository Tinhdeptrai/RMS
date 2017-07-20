function EditUser() {
	this.gird = null;
}

EditUser.prototype.constructor = function() {
	var that = this;
	this.gird = new GirdCustom("#btn-account-finish", "#btn-account-cancel", ".btn-user-delete", ".btn-add-new", "", ".new-line", [], "update-users");
	this.gird.constructor(
		function(id, fieldName, fieldValue) {
			return that.validateFields(id, fieldName, fieldValue)
		}, function(id) {
			return that.getUserObject(id);
		}
	);
}

/**
 * Get user object
 */
EditUser.prototype.getUserObject = function(id)
{
	var user = {};
	user.id = id;
	user.firstname = $('#object-'+id + ' .firstname').find('input').val();
	user.firstname1 = $('#object-'+id + ' .firstname1').find('input').val();
	user.lastname = $('#object-'+id + ' .lastname').find('input').val();
	user.lastname1 = $('#object-'+id + ' .lastname1').find('input').val();
	user.username = $('#object-'+id + ' .username').find('input').val();
	user.password = $('#object-'+id + ' .password').find('input').val();
	return user;
}

/**
 * Validate
 */
EditUser.prototype.validateFields = function(id, fieldName, type)
{
	var that = this;
	var user = this.getUserObject(id);
	if (fieldName == 'username') {
		var bool = false;
		$('.username').find('input').each(function() {
			if (user.username == $(this).val() && user.id != $(this).attr('data-id')) {
				bool = true;
			}
		});
		if (bool) {
			return {status: false, msg: MSG_USER_EXIST}; 
		} else {
			return {status: true};
		}
	} else if (fieldName == 'password' && user.password != '' && user.password != '********' && !that.checkPassword(user.password)) {
		return {status: false, msg: MSG_PASSWORD_CHECK};
	} else {
		return {status: true};
	}
}

/**
 * Check password
 */
EditUser.prototype.checkPassword = function(str)
{
    // at least one number, one lowercase and one uppercase letter
	// at least six characters
	var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
    return re.test(str);
}

$(document).ready(function() {
	var editUser = new EditUser();
	editUser.constructor();
});
