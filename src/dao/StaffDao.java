package dao;
/**
 * 
 * @author mehra
 * The methods that we need to save and retrieve data from the database
 */
import model.Dish;
import model.User;
public interface StaffDao {

	/**
	 * 
	 * @param c
	 * @return
	 */
//	public int register(String password);
	
	/*
	 * Retrieve the Customer object from the database
	 */
	public String validateCustomer(String userId, String password);

	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object

	public int addDish(Dish dish);
	
	public int removeDish(Dish dish);
}
