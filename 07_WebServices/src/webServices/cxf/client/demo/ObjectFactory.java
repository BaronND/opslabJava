
package webServices.cxf.client.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webServices.cxf.client.demo package. 
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

    private final static QName _GetStudentsList_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentsList");
    private final static QName _GetStudentsListResponse_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentsListResponse");
    private final static QName _GetStudentsMap_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentsMap");
    private final static QName _GetStudentById_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentById");
    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentByIdResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://inter.serv.cxf.webServices/", "addStudentResponse");
    private final static QName _GetStudentsMapResponse_QNAME = new QName("http://inter.serv.cxf.webServices/", "getStudentsMapResponse");
    private final static QName _AddStudent_QNAME = new QName("http://inter.serv.cxf.webServices/", "addStudent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webServices.cxf.client.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentsMapResponse }
     * 
     */
    public GetStudentsMapResponse createGetStudentsMapResponse() {
        return new GetStudentsMapResponse();
    }

    /**
     * Create an instance of {@link GetStudentsMapResponse.Return }
     * 
     */
    public GetStudentsMapResponse.Return createGetStudentsMapResponseReturn() {
        return new GetStudentsMapResponse.Return();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link GetStudentsMap }
     * 
     */
    public GetStudentsMap createGetStudentsMap() {
        return new GetStudentsMap();
    }

    /**
     * Create an instance of {@link GetStudentsListResponse }
     * 
     */
    public GetStudentsListResponse createGetStudentsListResponse() {
        return new GetStudentsListResponse();
    }

    /**
     * Create an instance of {@link GetStudentsList }
     * 
     */
    public GetStudentsList createGetStudentsList() {
        return new GetStudentsList();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsMapResponse.Return.Entry }
     * 
     */
    public GetStudentsMapResponse.Return.Entry createGetStudentsMapResponseReturnEntry() {
        return new GetStudentsMapResponse.Return.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentsList")
    public JAXBElement<GetStudentsList> createGetStudentsList(GetStudentsList value) {
        return new JAXBElement<GetStudentsList>(_GetStudentsList_QNAME, GetStudentsList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentsListResponse")
    public JAXBElement<GetStudentsListResponse> createGetStudentsListResponse(GetStudentsListResponse value) {
        return new JAXBElement<GetStudentsListResponse>(_GetStudentsListResponse_QNAME, GetStudentsListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentsMap")
    public JAXBElement<GetStudentsMap> createGetStudentsMap(GetStudentsMap value) {
        return new JAXBElement<GetStudentsMap>(_GetStudentsMap_QNAME, GetStudentsMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsMapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "getStudentsMapResponse")
    public JAXBElement<GetStudentsMapResponse> createGetStudentsMapResponse(GetStudentsMapResponse value) {
        return new JAXBElement<GetStudentsMapResponse>(_GetStudentsMapResponse_QNAME, GetStudentsMapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inter.serv.cxf.webServices/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

}
