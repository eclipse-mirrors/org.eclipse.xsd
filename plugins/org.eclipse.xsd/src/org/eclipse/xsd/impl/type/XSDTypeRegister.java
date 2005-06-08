/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XSDTypeRegister.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl.type;


import java.util.HashMap;
import java.util.Map;


public class XSDTypeRegister 
{
  protected static Map map;

  public static Map getMap()
  {
    if (map == null)
    {
      map = new HashMap();
      map.put("anySimpleType", new XSDAnySimpleType());
      map.put("anyURI", new XSDAnyURIType());
      map.put("duration", new XSDDurationType());
      map.put("base64Binary", new XSDBase64BinaryType());
      map.put("boolean", new XSDBooleanType());
      map.put("date", new XSDDateType());
      map.put("dateTime", new XSDDateTimeType());
      map.put("decimal", new XSDDecimalType());
      map.put("double", new XSDDoubleType());
      map.put("float", new XSDFloatType());
      map.put("gMonth", new XSDGMonthType());
      map.put("gMonthDay", new XSDGMonthDayType());
      map.put("gDay", new XSDGDayType());
      map.put("gYearMonth", new XSDGYearMonthType());
      map.put("gYear", new XSDGYearType());
      map.put("NOTATION", new XSDNotationType());
      map.put("hexBinary", new XSDHexBinaryType());
      map.put("QName", new XSDQNameType());
      map.put("time", new XSDTimeType());
    }
    return map;
  }

  public static XSDAnySimpleType getTypeImplementer(String primitiveTypeName)
  {
    XSDAnySimpleType xsdAnyType = (XSDAnySimpleType)getMap().get(primitiveTypeName);
    if (xsdAnyType == null)
    {
      xsdAnyType = (XSDAnySimpleType)map.get("anySimpleType");
    }
    return xsdAnyType;
  }
}
