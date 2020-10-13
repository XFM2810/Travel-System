
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicer package. 
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

    private final static QName _GetIP4Travel_QNAME = new QName("http://servicer/", "getIP4Travel");
    private final static QName _GetIP4TravelResponse_QNAME = new QName("http://servicer/", "getIP4TravelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIP4TravelResponse }
     * 
     */
    public GetIP4TravelResponse createGetIP4TravelResponse() {
        return new GetIP4TravelResponse();
    }

    /**
     * Create an instance of {@link GetIP4Travel_Type }
     * 
     */
    public GetIP4Travel_Type createGetIP4Travel_Type() {
        return new GetIP4Travel_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIP4Travel_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicer/", name = "getIP4Travel")
    public JAXBElement<GetIP4Travel_Type> createGetIP4Travel(GetIP4Travel_Type value) {
        return new JAXBElement<GetIP4Travel_Type>(_GetIP4Travel_QNAME, GetIP4Travel_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIP4TravelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicer/", name = "getIP4TravelResponse")
    public JAXBElement<GetIP4TravelResponse> createGetIP4TravelResponse(GetIP4TravelResponse value) {
        return new JAXBElement<GetIP4TravelResponse>(_GetIP4TravelResponse_QNAME, GetIP4TravelResponse.class, null, value);
    }

}
