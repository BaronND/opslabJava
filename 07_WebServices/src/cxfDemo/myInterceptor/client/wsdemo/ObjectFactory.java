
package cxfDemo.myInterceptor.client.wsdemo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cxfDemo.myInterceptor.client.wsdemo package. 
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

    private final static QName _HelloWS_QNAME = new QName("http://SEI.myInterceptor.cxfDemo/", "helloWS");
    private final static QName _HelloWSResponse_QNAME = new QName("http://SEI.myInterceptor.cxfDemo/", "helloWSResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cxfDemo.myInterceptor.client.wsdemo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloWS }
     * 
     */
    public HelloWS createHelloWS() {
        return new HelloWS();
    }

    /**
     * Create an instance of {@link HelloWSResponse }
     * 
     */
    public HelloWSResponse createHelloWSResponse() {
        return new HelloWSResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SEI.myInterceptor.cxfDemo/", name = "helloWS")
    public JAXBElement<HelloWS> createHelloWS(HelloWS value) {
        return new JAXBElement<HelloWS>(_HelloWS_QNAME, HelloWS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SEI.myInterceptor.cxfDemo/", name = "helloWSResponse")
    public JAXBElement<HelloWSResponse> createHelloWSResponse(HelloWSResponse value) {
        return new JAXBElement<HelloWSResponse>(_HelloWSResponse_QNAME, HelloWSResponse.class, null, value);
    }

}
