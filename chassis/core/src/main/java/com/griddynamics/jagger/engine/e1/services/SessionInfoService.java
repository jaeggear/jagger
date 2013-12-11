package com.griddynamics.jagger.engine.e1.services;

/** Create and modify session metadata(such as session comment)
 * @author Gribov Kirill
 * @n
 * @par Details:
 * @details
 * @n
 * */
public interface SessionInfoService extends JaggerService{

    /** Returns current session comment
     * @author Gribov Kirill
     *
     * @n
     *@return session comment */
    String getComment();

    /** Set new session comment
     * @author Gribov Kirill
     * @n
     * @param comment - new session comment */
    void setComment(String comment);

    /** Append string to current session comment
     * @author Gribov Kirill
     * @n
     * @param st - string to append */
    void appendToComment(String st);
}