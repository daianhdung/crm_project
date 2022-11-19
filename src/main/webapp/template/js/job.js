function showToastSuccess(heading, text){
    $.toast({
        heading: heading,
        text: text,
        position: 'top-right',
        loaderBg:'#ff6849',
        icon: 'success',
        hideAfter: 3500, 
        stack: 6
      });
}

function showToastError(heading, text){
    $.toast({
        heading: heading,
        text: text,
        position: 'top-right',
        loaderBg:'#ff6849',
        icon: 'error',
        hideAfter: 3500
      });
}

$(document).ready(function () {
    // find("selector")
    //parent(): đi ra cấp cha
    //closest(): đi ra n cấp chỉ định
    $(".btn-delete").click(function () {
        var id = $(this).attr("jobId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm_app/api/job?id=" + id,
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
    $('#edit-job').click(function (){
        var data = {}
        var formEditJob = $("#jobEdit").serializeArray()
        $.each(formEditJob, function (i, v) {
            data[""+v.name+""] = v.value
        })
        $.ajax({
            method: "PUT",
            url: "http://localhost:8081/crm_app/api/job",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: 'json',
        }).done(function (data){
            console.log(data);
            // window.location.href = "/admin-work?action=edit&id=" + data.id;
            showToastSuccess('Thao tác thành công', 'update job')
        }).fail(function (data){
            showToastError("Thất bại", 'update job')
        })
    });
})