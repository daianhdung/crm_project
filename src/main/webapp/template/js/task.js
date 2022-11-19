$(document).ready(function () {
    // find("selector")
    //parent(): đi ra cấp cha
    //closest(): đi ra n cấp chỉ định
    $(".btn-delete").click(function () {
        var id = $(this).attr("taskId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm_app/api/task?id=" + id,
            // data: { name: "John", location: "Boston" } => gửi tham số dạng post
        }).done(function( data ) {
            if(data.success){
                //Xóa thành công
                This.closest("tr").remove()
            }else {
                //xóa thất bại
                alert("Xoá thất bại")
            }
        })
    });
    $('#edit-task').click(function (){
        var data = {}
        var formEditTask = $("#taskEdit").serializeArray()
        $.each(formEditTask, function (i, v) {
            data[""+v.name+""] = v.value
        })
        $.ajax({
            method: "PUT",
            url: "http://localhost:8081/crm_app/api/task",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: 'json',
        }).done(function (data){
            console.log(data);
            if(data.success){
                showToastSuccess('Thao tác thành công', 'update task')
            }else{
                showToastError("Thất bại", 'update task')
            }
        }).fail(function (data){
            showToastError("Thất bại", 'update task')
        })
    });
})