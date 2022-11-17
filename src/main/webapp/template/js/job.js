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
        console.log(data)
    })
})