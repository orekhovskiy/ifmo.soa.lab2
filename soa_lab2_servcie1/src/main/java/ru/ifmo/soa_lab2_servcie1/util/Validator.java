package ru.ifmo.soa_lab2_servcie1.util;

import ru.ifmo.soa_lab2_servcie1.DAO.DAOImpl;
import ru.ifmo.soa_lab2_servcie1.entities.ProductsEntity;
import ru.ifmo.soa_lab2_servcie1.exceptions.NotFoundException;
import ru.ifmo.soa_lab2_servcie1.exceptions.WrongArgumentException;
import ru.ifmo.soa_lab2_servcie1.models.Country;
import ru.ifmo.soa_lab2_servcie1.models.Person;
import ru.ifmo.soa_lab2_servcie1.models.Product;
import ru.ifmo.soa_lab2_servcie1.models.UnitOfMeasure;

import static ru.ifmo.soa_lab2_servcie1.util.ExceptionsUtil.*;

public class Validator {
    public static void validateProduct(Product product, Long id)
            throws WrongArgumentException {
        // Id
        if (id != null) {
            if (product.getId() == null)
                throw new WrongArgumentException(getCouldNotBeNullException("Id"));
            if (product.getId() <= 0)
                throw new WrongArgumentException(getShouldBeGreaterException("Id", "0"));
            if (!product.getId().equals(id)) {
                boolean isIdUnique = false;
                try {
                    DAOImpl dao = new DAOImpl();
                    dao.getProductById(product.getId());
                } catch (NotFoundException e) {
                    isIdUnique = true;
                }
                if (!isIdUnique) {
                    throw new WrongArgumentException(getArgumentIsNotUniqueException("Id"));
                }
            }
        }
        // Name
        if (product.getName() == null)
            throw new WrongArgumentException(getCouldNotBeNullException("Name"));
        if (product.getName().equals(""))
            throw new WrongArgumentException(getCouldNotBeEmptyException("Name"));

        // Coordinates
        if (product.getCoordinates() == null)
            throw new WrongArgumentException(getCouldNotBeNullException("Coordinates"));
        if (product.getCoordinates().getX() <= -965)
            throw new WrongArgumentException(getShouldBeGreaterException("Coordinates.X", "-965"));

        // CreationDate
        if (product.getCreationDate() == null)
            throw new WrongArgumentException(getCouldNotBeNullException("CreationDate"));

        // Price
        if (product.getPrice() != null && product.getPrice() <= 0)
            throw new WrongArgumentException(getShouldBeGreaterException("Price", "0"));

        // PartNumber
        if (product.getPartNumber() != null && product.getPartNumber().length() <= 26)
            throw new WrongArgumentException(getShouldBeGreaterException("PartNumber.length()", "26"));
        DAOImpl dao = new DAOImpl();
        // unique
        if (id == null) {
            if (dao.getProductByPartNumber(product.getPartNumber()) != null)
                throw new WrongArgumentException(getArgumentIsNotUniqueException("PartNumber"));
        } else {
            ProductsEntity entity = dao.getProductByPartNumber(product.getPartNumber());
            if (entity != null && entity.getId() != product.getId())
                throw new WrongArgumentException(getArgumentIsNotUniqueException("PartNumber"));
        }

        // Owner
        validatePerson(product.getOwner());
    }
    public static void validatePerson(Person owner)
            throws WrongArgumentException {
        if (owner != null) {
            // Location
            if (owner.getLocation() == null)
                throw new WrongArgumentException(getCouldNotBeNullException("Owner.Location"));
            if (owner.getLocation().getY() == null)
                throw new WrongArgumentException(getCouldNotBeNullException("Owner.Location.Y"));

            // Name
            if (owner.getName() == null)
                throw new WrongArgumentException(getCouldNotBeNullException("Owner.Name"));
            if (owner.getName().equals(""))
                throw new WrongArgumentException(getCouldNotBeEmptyException("Owner.Name"));

            // Weight
            if (owner.getWeight() != null && owner.getWeight() <= 0)
                throw new WrongArgumentException(getShouldBeGreaterException("Owner.Weight", "0"));

            // Nationality
            if (owner.getNationality() == null)
                throw new WrongArgumentException(getCouldNotBeNullException("Owner.Nationality"));
        }
    }

    public static  void validateEnum(String enumName, String enumValue) throws WrongArgumentException {
        if (enumName.equals("unitofmeasure")) {
            if (!enumValue.equals("GRAMS") && !enumValue.equals("MILLIGRAMS") && !enumValue.equals("CENTIMETERS")) {
                throw new WrongArgumentException(ExceptionsUtil.getEnumException("UnitOfMeasure"));
            }
        }
        if (enumName.equals("ownernationality")) {
            if (!enumValue.equals("USA") && !enumValue.equals("CHINA") && !enumValue.equals("INDIA") && !enumValue.equals("THAILAND")) {
                throw new WrongArgumentException(ExceptionsUtil.getEnumException("Owner.Nationality"));
            }
        }
    }
}
