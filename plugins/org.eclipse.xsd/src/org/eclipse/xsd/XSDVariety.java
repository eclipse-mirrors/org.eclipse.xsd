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
 * $Id: XSDVariety.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variety</b></em>'.
 * @see org.eclipse.xsd.XSDSimpleTypeDefinition#getVariety()
 * @<!-- end-user-doc -->
 * @see org.eclipse.xsd.XSDPackage#getXSDVariety()
 * @model
 * @generated
 */
public final class XSDVariety extends AbstractEnumerator
{
  /**
   * The '<em><b>Atomic</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate that a simple type definition is <a href="http://www.w3.org/TR/xmlschema-2/#dt-atomic">atomic</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #ATOMIC_LITERAL
   * @model name="atomic"
   * @generated
   * @ordered
   */
  public static final int ATOMIC = 0;

  /**
   * The '<em><b>List</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate that a simple type definition is a <a href="http://www.w3.org/TR/xmlschema-2/#dt-list">list</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #LIST_LITERAL
   * @model name="list"
   * @generated
   * @ordered
   */
  public static final int LIST = 1;

  /**
   * The '<em><b>Union</b></em>' literal value.
   * <!-- begin-user-doc --> 
   * <p>
   * This is used to indicate that a simple type definition is a <a href="http://www.w3.org/TR/xmlschema-2/#dt-union">union</a>.
   * </p>
   * <!-- end-user-doc --> 
   * @see #UNION_LITERAL
   * @model name="union"
   * @generated
   * @ordered
   */
  public static final int UNION = 2;
  /**
   * The '<em><b>Atomic</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #ATOMIC
   * @generated
   * @ordered
   */
  public static final XSDVariety ATOMIC_LITERAL = new XSDVariety(ATOMIC, "atomic");

  /**
   * The '<em><b>List</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #LIST
   * @generated
   * @ordered
   */
  public static final XSDVariety LIST_LITERAL = new XSDVariety(LIST, "list");

  /**
   * The '<em><b>Union</b></em>' literal object.
   * <!-- begin-user-doc --> 
   * <p>
   * </p>
   * <!-- end-user-doc --> 
   * @see #UNION
   * @generated
   * @ordered
   */
  public static final XSDVariety UNION_LITERAL = new XSDVariety(UNION, "union");

  /**
   * An array of all the '<em><b>Variety</b></em>' enumerators.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  private static final XSDVariety[] VALUES_ARRAY =
    new XSDVariety[]
    {
      ATOMIC_LITERAL,
      LIST_LITERAL,
      UNION_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>Variety</b></em>' enumerators.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Variety</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static XSDVariety get(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      XSDVariety result = VALUES_ARRAY[i];
      if (result.toString().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Variety</b></em>' literal with the specified value.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  public static XSDVariety get(int value)
  {
    switch (value)
    {
      case ATOMIC: return ATOMIC_LITERAL;
      case LIST: return LIST_LITERAL;
      case UNION: return UNION_LITERAL;
    }
    return null;	
  }

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc --> 
   * <!-- end-user-doc --> 
   * @generated
   */
  private XSDVariety(int value, String name)
  {
    super(value, name);
  }

} 
