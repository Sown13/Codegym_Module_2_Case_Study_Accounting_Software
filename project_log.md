1/ Product:
- ProductEXPLimited: Sản phẩm có hạn sử dụng
- ProductEXPUnLimited: Sp ko có hạn sử dụng
2/ List:
- Cấu trúc dữ liệu dùng để lưu trữ số lượng sản phẩm theo cấu trúc nhập trước xuất trước queue
- ProductQueue: sản phẩm cùng tên được xếp vào đây, theo cấu trúc queue - (linkedlist)
- ProductQueueManager: static, danh sách sản phẩm (danh sách queue) - (Arraylist)
- NoteManager: static, danh sách phiếu nhập xuất kho - (arraylist)
- UserManager: static, danh sách user - (hashmap)

3/ bill:
- Phiếu nhập kho: 
    + Do thủ kho (storekeeper) 
    + Phiếu lập xong sẽ tạo thêm sản phẩm mới ngay, nếu sp này đã tồn tại thì sẽ đc thêm vào queue
    + Tính tiền chi ra mua hàng : do kế toán thực hiện bút toán
- Phiếu xuất kho:
    + Do thủ kho hoặc nhân viên bán hàng (sale staff) lập
    + Phiếu lập xong sẽ trừ đi hàng tồn kho ngay, sản phẩm xuất ra buộc phải là sản phẩm đã có trong kho
    + Tính tiền thu về (=0 nếu xuất do hư hỏng) : do kế toán thực hiện bút toán

4/ Account:
- Ghi nhận các bút toán
- Tạm thời suspend mở rộng sau

5/ User:
- admin: tk cố định và duy nhất, có các chức năng:
    + Thêm tiền vào tài khoản nguồn vốn
    + Quản lý Useres (thêm/xóa/sửa user)
    + Kiếm tra kết quả kinh doanh
    + Tất cả các thao tác mà hệ thống có
- Accountant: do admin phân phối
    + Có quyền truy cập danh sách phiếu xuất/ nhập kho
    + Báo cáo kq kinh doanh
- StoreKeeper: do admin phân phối
    + Có quyền quản lý phiếu xuất/nhập kho

- Sale staff: do admin phân phối
    + chí có quyền lập phiếu xuất kho cho mục đích bán hàng