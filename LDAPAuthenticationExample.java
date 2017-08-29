import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

/**
 * This program demonstrates how to connect and authenticate a Java program
 * to a LDAP server using JNDI APIs.
 * @author www.codejava.net
 */
public class LDAPAuthenticationExample {
	public static void main(String[] args) {
		String url = "ldap://localhost:10389";
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		env.put(Context.SECURITY_CREDENTIALS, "secret");

		try {
			DirContext ctx = new InitialDirContext(env);
			System.out.println("connected");
			System.out.println(ctx.getEnvironment());
			
			// do something useful with the context...

			ctx.close();

		} catch (AuthenticationNotSupportedException ex) {
			System.out.println("The authentication is not supported by the server");
		} catch (AuthenticationException ex) {
			System.out.println("incorrect password or username");
		} catch (NamingException ex) {
			System.out.println("error when trying to create the context");
		}
	}
		
}