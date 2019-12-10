
package services;

import java.util.List;
import model.DAO.DeviceDAO;
import model.Device;
import model.Interface.IDevice;


public class DeviceService implements IDevice {

    private DeviceDAO deviceDAO = new DeviceDAO();
    
    @Override
    public List<Device> getAllDevice() {
        return deviceDAO.getAllDevice();
    }

    @Override
    public void insertDevice(Device device) {
        deviceDAO.insertDevice(device);
    }

    @Override
    public void editDevice(Device device) {
        deviceDAO.editDevice(device);
    }

    @Override
    public void deleteDevice(int maLK) {
        deviceDAO.deleteDevice(maLK);
    }
    
    @Override
    public List<Device> searchDevice(String tenLK) {
        return deviceDAO.searchDevice(tenLK);
    }
    
    @Override
     public Device find(int maLK){
         return deviceDAO.find(maLK);
     }
}
