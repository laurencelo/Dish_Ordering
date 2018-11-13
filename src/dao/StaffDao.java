package dao;
/**
 * 
 * @author mehra
 * The methods that we need to save and retrieve data from the database
 */
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
	public String validateCustomer(String password);

	
	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object

	public int addDish(String dishName, double dishPrice, int dishInventory);
	
	public int removeDish(String dishName);
}
