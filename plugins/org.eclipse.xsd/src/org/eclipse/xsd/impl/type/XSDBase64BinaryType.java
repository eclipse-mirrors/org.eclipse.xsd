/**
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */
package org.eclipse.xsd.impl.type;

import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;

public class XSDBase64BinaryType extends XSDAnySimpleType
{
  @Override
  public Object getValue(String literal)
  {
    byte[] bytes = Base64.decode(literal);
    return (bytes != null) ? new ByteSequence(this, bytes) : null;
  }
}
