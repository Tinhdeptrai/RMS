function EditCourse() {
	this.gird = null;
}

EditCourse.prototype.constructor = function() {
	var that = this;
	this.gird = new GirdCustom("#btn-course-finish", "#btn-course-cancel", ".btn-course-delete", ".btn-add-new", "", ".new-line", [], "update-course");
	this.gird.constructor(
		function(id, fieldName, fieldValue) {
			return that.validateFields(id, fieldName, fieldValue)
		}, function(id) {
			return that.getObject(id);
		}
	);
}

/**
 * Get object
 */
EditCourse.prototype.getObject = function(id)
{
	var course = {};
	course.id = id;
	course.name = $('#object-'+id + ' .name').find('input').val();
	return course;
}

/**
 * Validate
 */
EditCourse.prototype.validateFields = function(id, fieldName, type)
{
	// TODO: nothing to validate now
	return {status: true};
}

$(document).ready(function() {
	var editCourse = new EditCourse();
	editCourse.constructor();
});

