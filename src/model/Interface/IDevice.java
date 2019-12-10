
package model.Interface;

import java.sql.SQLException;
import java.util.List;
import model.Device;


public interface IDevice {
    public List<Device> getAllDevice();
    public void insertDevice(Device device);
    public void editDevice(Device device);
    public void deleteDevice(int maLK);
    public List<Device> searchDevice(String tenLK);
    public Device find(int maLK);
}
