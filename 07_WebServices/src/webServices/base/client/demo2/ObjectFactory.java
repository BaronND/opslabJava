
package webServices.base.client.demo2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webServices.base.client.demo2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Network_QNAME = new QName("http://service.base.webServices/", "network");
    private final static QName _NetworkResponse_QNAME = new QName("http://service.base.webServices/", "networkResponse");
    private final static QName _TimeResponse_QNAME = new QName("http://service.base.webServices/", "timeResponse");
    private final static QName _Mem_QNAME = new QName("http://service.base.webServices/", "mem");
    private final static QName _MemResponse_QNAME = new QName("http://service.base.webServices/", "memResponse");
    private final static QName _Time_QNAME = new QName("http://service.base.webServices/", "time");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webServices.base.client.demo2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Network }
     * 
     */
    public Network createNetwork() {
        return new Network();
    }

    /**
     * Create an instance of {@link Mem }
     * 
     */
    public Mem createMem() {
        return new Mem();
    }

    /**
     * Create an instance of {@link NetworkResponse }
     * 
     */
    public NetworkResponse createNetworkResponse() {
        return new NetworkResponse();
    }

    /**
     * Create an instance of {@link TimeResponse }
     * 
     */
    public TimeResponse createTimeResponse() {
        return new TimeResponse();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link MemResponse }
     * 
     */
    public MemResponse createMemResponse() {
        return new MemResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Network }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "network")
    public JAXBElement<Network> createNetwork(Network value) {
        return new JAXBElement<Network>(_Network_QNAME, Network.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "networkResponse")
    public JAXBElement<NetworkResponse> createNetworkResponse(NetworkResponse value) {
        return new JAXBElement<NetworkResponse>(_NetworkResponse_QNAME, NetworkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "timeResponse")
    public JAXBElement<TimeResponse> createTimeResponse(TimeResponse value) {
        return new JAXBElement<TimeResponse>(_TimeResponse_QNAME, TimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "mem")
    public JAXBElement<Mem> createMem(Mem value) {
        return new JAXBElement<Mem>(_Mem_QNAME, Mem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "memResponse")
    public JAXBElement<MemResponse> createMemResponse(MemResponse value) {
        return new JAXBElement<MemResponse>(_MemResponse_QNAME, MemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Time }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.webServices/", name = "time")
    public JAXBElement<Time> createTime(Time value) {
        return new JAXBElement<Time>(_Time_QNAME, Time.class, null, value);
    }

}
