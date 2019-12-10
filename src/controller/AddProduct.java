package controller;

import model.Customer;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.CustomerService;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mesErr = null;
        // Thong tin san pham
        String imei = req.getParameter("IMEI");
        String tenSP =req.getParameter("TENSP");
        String nsx = req.getParameter("NSX");
        String loaiSp = req.getParameter("LOAISP");
        String thongtinsp = req.getParameter("THONGTINSP");
        String thoigianbaohanh = req.getParameter("THOIGIANBAOHANH");
        // Thong tin khach hang
        String tenKH = req.getParameter("TENKH");
        String dienThoai =req.getParameter("DIENTHOAI");
        String email = req.getParameter("EMAIL");
        String diaChi = req.getParameter("DIACHI");

        //Them khach hang vao database
        CustomerService customerService = new CustomerService();

        try {
            Customer customer =  customerService.searchByPhone(dienThoai);
            customerService.addCustomer(tenKH,dienThoai,email,diaChi);

            // Them file anh vào view/img, luu ten anh vao database
            // Can them 2 thu vien de su dung: commons-fileupload va commons-io .

            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setRepository(new File("D:/OOP/BTLon/BTL_OOP_QLBH/web")); //Tao thu muc chua tam file
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            String fileName = null;

            List<FileItem> fileItems = fileUpload.parseRequest(req); // lay file anh trong req
            for (FileItem fileItem : fileItems){    // duyet tat ca file anh
                if (fileItem.isFormField()){        // Neu file anh trong form can upload len DB
                    if (fileItem.getFieldName().equals("HINHANHSP")){  // Neu file co name = HINHANHSP
                        fileName = fileItem.getName(); // Lay ten anh
                        File file = new File("D:/OOP/BTLon/BTL_OOP_QLBH/web/view/img/"+ fileItem.getName()); // Thu muc can them file vao
                        fileItem.write(file); // viet file vao thu muc

                    }
                }
            }

            Product product = new Product();
            product.setImei(imei);
            product.setTenSP(tenSP);
            product.setNxs(nsx);
            product.setLoaiSP(loaiSp);
            product.setHanBaoHanh(thoigianbaohanh);
            product.setThongTinSP(thongtinsp);
            product.setHinhAnh("/view/img/"+fileName);
            ProductService productService = new ProductService();

            productService.addProduct(product,customer.getMaKH());

                req.setAttribute("mesErr","Thêm thành công.");
                RequestDispatcher dispatcher = req.getRequestDispatcher(req.getRequestURL().toString());
                dispatcher.forward(req,resp);


        } catch (Exception e) {
            mesErr = "Đã xảy ra lỗi, hãy thực hiện lại";
            req.setAttribute("mesErr",mesErr);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/form-addSP_KH.jsp");
            dispatcher.forward(req,resp);
            e.printStackTrace();
        }
        // Them san pham vao DB





    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
