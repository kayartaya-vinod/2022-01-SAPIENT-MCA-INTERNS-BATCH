package co.vinod.service;

public class AccountService{

	private static AccountService instance; // = new AccountService(); // eager instantiation

	// prevents object creation outside of this class
	private AccountService() {
		System.out.println("AccountService instantiated!");
		if(instance!=null){
			throw new RuntimeException("Not allowed!");
		}
	}

	// factory method (virtual constructor)
	public static AccountService getInstance() {
		
		if(instance==null){
			instance = new AccountService();
		}
		return instance;
	}
}
