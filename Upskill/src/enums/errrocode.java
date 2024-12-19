package enums;

public enum errrocode {
 NOT_FOUND(404,"The page not found"),
 UNAUTHORIZED(401,"PAGE REStricted"),
 FORBIDDEN(403,"PAGE FORBIDDEN");
	private final int errorcode1;
	private final String message;
  errrocode(int errorcode1,String message) {
	 this.errorcode1=errorcode1;
	 this.message=message;
 }
  public int getErrorCode1() {
	  return errorcode1;
  }
  public String getMessage() {
	  return message;
  }
  public static errrocode findByCode(int code) {
	  for(errrocode cod:errrocode.values()) {
		  if(cod.getErrorCode1()==code) {
			  return cod;
		  }
	  }
	  return null;
  }
  public static void main(String[] args) {
	int searchcode=403;
	errrocode error=errrocode.findByCode(searchcode);
	System.out.printf("Error Code: %s (%d) | With Error Message: %s%n", 
            error, error.getErrorCode1(), error.getMessage());
}
}

