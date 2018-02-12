package spring.boot.jersey.rest.model;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;

import java.net.URI;

public class Helper {

    @InjectLink(value = "cats/{id}", condition = "${not empty instance.id}", style = InjectLink.Style.ABSOLUTE,
            bindings = @Binding(name = "id", value = "${instance.id}"),
            rel = "href")
    private URI href;
    private Long id;

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
