package com.adarsh.spring.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class ApplicationUtil {

    public static Date getDate(String date) {
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            return new Date(simpleDateFormat.parse(date).getTime());
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return null;
    }
}
