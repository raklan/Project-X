public class Cipher {

    // set global private variables (attributes)
    private int key;
    private String message;
    private String encMessage;
    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // notice that I put a space so I can encrypt spaces too

    /**
     * Default Constructor - Creates a new instance of Cipher Default values are
     * set key = 3; message = "Test Message"; values can be overwritten using
     * the setters
     */
    public Cipher() {
        this.key = 3;
        this.message = "Java Rocks";
    }

    /**
     * Constructor - Creates a new instance of Cipher No default values are set
     * Must pass parameters when constructing
     *
     * @param key
     *            the encryption offset
     * @param message
     *            the message you want encrypted
     */
    public Cipher(int key, String message) {
        this.key = key;
        this.message = message;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int param) {
        this.key = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String param) {
        this.message = param;
    }

    public String getEncMessage() {
        return encMessage;
    }

    public void setEncMessage(String param) {
        this.encMessage = param;
    }

    /**
     * Method to encrypt the message. Only call this after set attributes
     *
     * @return The encrypted message
     */
    public String encrypt() {
        // assign the attributes to some private method variables -- not really
        // necessary to do this
        int theKey = this.key;
        String theMessage = this.message;

        String coded = ""; // coded is variable used to build and store the
        // encrypted message

        theMessage = theMessage.toUpperCase(); // change message to all upper
        // case

        for (int i = 0; i < theMessage.length(); i++) { // for as many letters
            // as there are
            char ch = theMessage.charAt(i); // access each letter in message
            int index = ALPHA.indexOf(ch); // find its position in ALPHA
            if (index == -1) { // if it's not in the ALPHA string,
                coded = coded + ch; // then leave it as is & add to coded
            } else { // otherwise find the corresponding shifted letter
                int shift = (index + theKey) % 27; // changed to 27 since added
                // ' '
                coded = coded + ALPHA.charAt(shift); // and add to coded
            }
        }

        this.encMessage = coded;
        return encMessage;
    }

    /**
     * Decrypts the message
     *
     * @return the decypted message
     */
    public String decrypt() {
        // assign the attributes to some private method variables -- not really
        // necessary to do this
        int theKey = this.key;
        String theMessage = this.encMessage;

        String plain = ""; // plain is variable used to build and store decrypted message

        theMessage = theMessage.toUpperCase(); // change message to all upper case

        for (int i = 0; i < theMessage.length(); i++) { // for as many letters as there are
            char ch = theMessage.charAt(i); // access each letter in message
            int index = ALPHA.indexOf(ch); // find its position in ALPHA
            if (index == -1) { // if it's not in the ALPHA string,
                plain = plain + ch; // then leave it as is & add
            } else { // otherwise find the corresponding shifted letter
                int shift = (index - theKey + 27) % 27; // changed this to 27 because added ' '
                plain = plain + ALPHA.charAt(shift); // and add
            }
        }
        return plain;
    }

    /**
     * This a our implementation of toXML(), by calling this on the object we
     * create, we can display an xml version of the object
     *
     * @return
     */
    public String toXML() {
        StringBuffer buf = new StringBuffer();
        buf.append("<cipher>\n");
        buf.append("\t<key>" + this.key + "</key>\n");
        buf.append("\t<message>" + this.message + "</message>\n");
        buf.append("</cipher>\n");
        return buf.toString();
    }

}