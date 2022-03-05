$(document).ready(function () {
    let subject = $('#addMarkSubject');
    addTeacher(subject.val());
    subject.change(function () {
        addTeacher(subject.val());
    });
});

function addTeacher(subjectId) {
    $.ajax({
        method: "POST",
        url: "/api/teachers",
        data: {subjectId: subjectId},
        success: function (response) {
            let data = '';
            $.each(response, function (idx, value) {
                data += '<option value=' + response[idx].id + '>'
                    + response[idx].firstName + ' '
                    + response[idx].lastName + '</option>';
            });
            $('#addMarkTeacher').html(data);
        }
    });
}