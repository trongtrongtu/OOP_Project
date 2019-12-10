package controller;

import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

@WebServlet(urlPatterns = "/edit-product")
public class EditProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String mesErr = null;

        // Thong tin san pham
        String imei = req.getParameter("IMEI");
        String tenSP =req.getParameter("TENSP");
        String nsx = req.getParameter("NSX");
        String loaiSp = req.getParameter("LOAISP");
        String thongtinsp = req.getParameter("THONGTINSP");
        String thoigianbaohanh = req.getParameter("THOIGIANBAOHANH");
        //---------------------------------
        // Lấy file ảnh.
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File("D:/OOP/BTLon/BTL_OOP_QLBH/web")); //Tao thu muc chua tam file
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        String fileName = null;
        try {
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
        } catch (Exception e) {
            mesErr = "Đã xảy ra lỗi, hãy thực hiện lại";
            e.printStackTrace();
        }

        //---------------------------------

        ProductService productService = new ProductService();

        try {
            productService.editProduct(imei,tenSP,loaiSp,nsx,thoigianbaohanh,fileName,thongtinsp);
            mesErr = "Đã xảy ra lỗi, hãy thực hiện lại";
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (mesErr == null){
            req.setAttribute("mesErr","Chỉnh sửa thành công.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/san-pham.html");
            dispatcher.forward(req,resp);
        }else {
            req.setAttribute("mesErr",mesErr);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/from-editSP.jsp");
            dispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
