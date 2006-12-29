/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: XSDDateTimeType.java,v 1.5 2006/12/29 18:16:22 marcelop Exp $
 */
package org.eclipse.xsd.impl.type;

import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;

public class XSDDateTimeType extends XSDAnySimpleType
{

  @Override
  public Object getValue(String normalizedLiteral)
  {
    try
    {
      return new XMLCalendar(normalizedLiteral, XMLCalendar.DATETIME);
    }
    catch (RuntimeException exception)
    {  
      // Ignore
    }
    return null;
  }

  @Override
  public int compareValues(Object value1, Object value2)
  {
    return XMLCalendar.compare((XMLCalendar)value1, (XMLCalendar)value2);
  }
}
