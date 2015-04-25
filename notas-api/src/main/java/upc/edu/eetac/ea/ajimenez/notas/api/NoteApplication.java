package upc.edu.eetac.ea.ajimenez.notas.api;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class NoteApplication extends ResourceConfig{

	public NoteApplication(){
		super();
		register(DeclarativeLinkingFeature.class);
	}
}
