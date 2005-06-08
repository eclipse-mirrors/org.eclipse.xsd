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
 * $Id: XSDWhiteSpace.java,v 1.1.2.1 2005/06/08 18:26:22 nickb Exp $
 */
package org.eclipse.xsd;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>White Space</b></em>'.
 * @see org.eclipse.xsd.XSDWhiteSpaceFacet#getValue()
 * @<!-- end-user-doc -->
 * @see org.eclipse.xsd.XSDPackage#getXSDWhiteSpace()
 * @model
 * @generated
 */
public final class XSDWhiteSpace extends AbstractEnumerator
{
  /**
   * The '<em><b>Preserve</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate the white space is <a href="http://www.w3.org/TR/xmlschema-2/#dt-whitespace">preserved</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #PRESERVE_LITERAL
   * @model name="preserve"
   * @generated
   * @ordered
   */
  public static final int PRESERVE = 0;

  /**
   * The '<em><b>Replace</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate the white space is <a href="http://www.w3.org/TR/xmlschema-2/#dt-whitespace">replaced</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #REPLACE_LITERAL
   * @model name="replace"
   * @generated
   * @ordered
   */
  public static final int REPLACE = 1;

  /**
   * The '<em><b>Collapse</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate the white space is <a href="http://www.w3.org/TR/xmlschema-2/#dt-whitespace">collapsed</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #COLLAPSE_LITERAL
   * @model name="collapse"
   * @generated
   * @ordered
   */
  public static final int COLLAPSE = 2;
  /**
   * The '<em><b>Preserve</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #PRESERVE
   * @generated
   * @ordered
   */
  public static final XSDWhiteSpace PRESERVE_LITERAL = new XSDWhiteSpace(PRESERVE, "preserve");

  /**
   * The '<em><b>Replace</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #REPLACE
   * @generated
   * @ordered
   */
  public static final XSDWhiteSpace REPLACE_LITERAL = new XSDWhiteSpace(REPLACE, "replace");

  /**
   * The '<em><b>Collapse</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #COLLAPSE
   * @generated
   * @ordered
   */
  public static final XSDWhiteSpace COLLAPSE_LITERAL = new XSDWhiteSpace(COLLAPSE, "collapse");

  /**
   * An array of all the '<em><b>White Space</b></em>' enumerators.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  private static final XSDWhiteSpace[] VALUES_ARRAY =
    new XSDWhiteSpace[]
    {
      PRESERVE_LITERAL,
      REPLACE_LITERAL,
      COLLAPSE_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>White Space</b></em>' enumerators.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>White Space</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static XSDWhiteSpace get(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      XSDWhiteSpace result = VALUES_ARRAY[i];
      if (result.toString().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>White Space</b></em>' literal with the specified value.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static XSDWhiteSpace get(int value)
  {
    switch (value)
    {
      case PRESERVE: return PRESERVE_LITERAL;
      case REPLACE: return REPLACE_LITERAL;
      case COLLAPSE: return COLLAPSE_LITERAL;
    }
    return null;	
  }

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  private XSDWhiteSpace(int value, String name)
  {
    super(value, name);
  }

} 
