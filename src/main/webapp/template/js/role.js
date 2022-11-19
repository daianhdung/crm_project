//$ => jquerry

$(document).ready(function () {
    // find("selector")
    //parent(): đi ra cấp cha
    //closest(): đi ra n cấp chỉ định
    $(".btn-deleteRole").click(function () {
        var id = $(this).attr("roleId")
        var This = $(this)
        $.ajax({
            method: "delete",
            url: "http://localhost:8081/crm_app/api/role?id=" + id,
            // data: { name: "John", location: "Boston" } => gửi tham số dạng post
        }).done(function( data ) {
                    //Xóa thành công
                    if(data.success){
                        This.closest("tr").remove()
                        showToastSuccess('Thao tác thành công', 'delete role')
                    }else{
                        showToastError("Thất bại", 'delete role')
                    }
                    
            }).fail(function (data){
                showToastError("Thất bại", 'delete role')
        })
    })
})