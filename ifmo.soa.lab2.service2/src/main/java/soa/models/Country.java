/**
 * Перечисление Стран
 * @author Anton Orekhovskiy
 * @version 1.0
 */
package soa.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Country {
    USA,
    CHINA,
    INDIA,
    THAILAND;
}
