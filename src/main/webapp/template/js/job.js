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
                showToastSuccess('Thao tác thành công', 'delete job')
            }else {
                //xóa thất bại
                showToastError("Thất bại", data.description)
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
           if(data.success){
               showToastSuccess('Thao tác thành công', data.description)
               console(123123)
           }else{
               showToastError("Thất bại", data.description + '.Vui lòng nhập đúng dữ liệu')
           }
        }).fail(function (data){
            showToastError("Thất bại", data.description)
        })
    });
})