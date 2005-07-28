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
 * $Id: XSDFloatType.java,v 1.3.2.2 2005/07/28 23:24:36 nickb Exp $
 */
package org.eclipse.xsd.impl.type;

public class XSDFloatType extends XSDAnySimpleType
{

  public Object getValue(String literal)
  {
    try 
    {
      return new Float(literal);
    }
    catch (NumberFormatException e)
    {
      return null;
    }
  }

  public int compareValues(Object value1, Object value2)
  {
    return ((Float)value1).compareTo((Float)value2);
  }
}
