$(document).ready(function () {

    if (document.location.href.indexOf('/journal/new/') > -1) {
        let subject = $('#addMarkSubject');
        addTeacher(subject.val());
        subject.change(function () {
            addTeacher(subject.val());
        });
    }
    if (document.location.href.indexOf('/journal/students/') > -1) {
        let cell = $('td[mark]');
        console.log(cell.length);
        cell.dblclick(function (e) {
            editMark(e);
        });

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

function editMark(e) {
    let cell = e.target;

    let row = cell.parentNode.rowIndex;
    let column = cell.cellIndex;
    console.log('Row: ' + row);
    console.log('Column: ' + column);

    console.log($('#marks tbody').rows);
}


function getMarks(subjectId) {
    $.ajax({
        method: "POST",
        url: "/api/journal",
        data: {subjectId: subjectId},
        success: function (response) {
            let data = '';
            console.log(response);
            $.each(response, function (idx, value) {
                let mark = value.value;
                let color = mark < 3 ?
                    'btn btn-danger' : mark > 3 ?
                        'btn btn-success' : 'btn btn-warning';
                let cell = "<a class='"
                    + color
                    + "' href='/journal/edit/"
                    + value.id + "'>"
                    + mark + "</a>";

                data += '<tr><td>' + (idx + 1) + '</td><td>'
                    + value.created + '</td><td>'
                    + value.student.firstName + ' '
                    + value.student.lastName + '</td><td>'
                    + value.subject.title + '</td><td>'
                    + value.teacher.firstName + ' '
                    + value.teacher.lastName + '</td><td>'
                    + cell + '</td></tr>'
            });
            $('#journal tbody').html(data);

        }
    });
}