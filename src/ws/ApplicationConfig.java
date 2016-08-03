package ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<Class<?>>();
		addRestResourceClesses(resources);
		return resources;
	}
	
	private void addRestResourceClesses( Set<Class<?>> resources){
		resources.add(Connection.class);
	}
	
}
;