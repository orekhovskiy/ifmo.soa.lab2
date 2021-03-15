/**
 * Перечисление Стран
 * @author Anton Orekhovskiy
 * @version 1.0
 */
package ru.ifmo.soa_lab2_servcie1.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Country {
    USA,
    CHINA,
    INDIA,
    THAILAND;
}
