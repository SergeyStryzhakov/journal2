$(document).ready(function () {
    if (document.location.pathname === '/journal/new') {

        let subject = $('#addMarkSubject');
        addTeacher(subject.val());
        subject.change(function () {
            addTeacher(subject.val());
        });
    }
    if (document.location.pathname === '/journal') {
        let cell = $('td');
        if (cell.attr("mark") !== undefined) {
            cell.dblclick(function () {
                console.log("Mark detected: " + cell.attr("mark"));
                editMark(event.target);
            });
        }
    }
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

function editMark() {
    let cell = event.target;
    console.log(cell.getAttribute("mark_id"));
    console.log('Column: ' + cell.parentNode.cellIndex);
    console.log('Row: ' + cell.parentNode.parentNode.rowIndex);
}