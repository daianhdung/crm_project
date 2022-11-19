$(document).ready(function () {
    // find("selector")
    //parent(): đi ra cấp cha
    //closest(): đi ra n cấp chỉ định
    $(".btn-delete").click(function () {
        var id = $(this).attr("memId")
        var This = $(this)
        $.ajax({
            method: "get",
            url: "http://localhost:8081/crm_app/api/user?id=" + id,
            // data: { name: "John", location: "Boston" } => gửi tham số dạng post
        }).done(function( data ) {
            if(data.success){
                //Xóa thành công
                This.closest("tr").remove()
                showToastSuccess('Thao tác thành công', 'delete member')
            }else {
                //xóa thất bại
                showToastError("Thất bại", 'delete member')
            }
        });
    })
})