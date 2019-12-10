/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.DAO.DonBhDAOImpl;
import java.util.List;
import model.DonBh;

/**
 *
 * @author DELL LATITUDE
 */
public class DonBhService implements model.Interface.DonBhDAO{
    private DonBhDAOImpl dao = new DonBhDAOImpl();
    @Override
    public void insert(DonBh don) {
        dao.insert(don);
    }

    @Override
    public void delete(int maDon) {
       dao.delete(maDon);
    }

    @Override
    public void edit(DonBh donMoi) {
        dao.edit(donMoi);
    }

    @Override
    public List<DonBh> getAll() {
        return dao.getAll();
    }

    @Override
    public DonBh get(int maDon) {
        return dao.get(maDon);
    }
    
    @Override
    public DonBh searchByImei(String imei) {
     return dao.searchByImei(imei);
    }
}
