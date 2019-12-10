/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interface;

import java.sql.SQLException;
import java.util.List;
import model.DonBh;

/**
 *
 * @author DELL LATITUDE
 */
public interface DonBhDAO {
    void insert(DonBh don);
    void delete(int maDon);
    void edit(DonBh don);
    List<DonBh> getAll();
    DonBh get(int maDon);
    DonBh searchByImei(String imei);
}
