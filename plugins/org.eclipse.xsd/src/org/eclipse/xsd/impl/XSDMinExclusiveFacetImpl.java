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
 * $Id: XSDMinExclusiveFacetImpl.java,v 1.2.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.Collection;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDMinExclusiveFacet;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Min Exclusive Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class XSDMinExclusiveFacetImpl 
  extends XSDMinFacetImpl 
  implements XSDMinExclusiveFacet
{
  public static XSDMinExclusiveFacet createMinExclusiveFacet(Node node)
  {
    if (XSDConstants.nodeType(node) == XSDConstants.MINEXCLUSIVE_ELEMENT)
    {
      XSDMinExclusiveFacet xsdMinExclusiveFacet = XSDFactory.eINSTANCE.createXSDMinExclusiveFacet();
      xsdMinExclusiveFacet.setElement((Element)node);
      return xsdMinExclusiveFacet;
    }

    return null;
  }

  protected XSDMinExclusiveFacetImpl() 
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return XSDPackage.eINSTANCE.getXSDMinExclusiveFacet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__DIAGNOSTICS:
          return ((InternalEList)getDiagnostics()).basicRemove(otherEnd, msgs);
        case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ANNOTATION:
          return basicSetAnnotation(null, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ELEMENT:
        return getElement();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__LEXICAL_VALUE:
        return getLexicalValue();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FACET_NAME:
        return getFacetName();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__EFFECTIVE_VALUE:
        return getEffectiveValue();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ANNOTATION:
        return getAnnotation();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__SIMPLE_TYPE_DEFINITION:
        return getSimpleTypeDefinition();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FIXED:
        return isFixed() ? Boolean.TRUE : Boolean.FALSE;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__VALUE:
        return getValue();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__INCLUSIVE:
        return isInclusive() ? Boolean.TRUE : Boolean.FALSE;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__EXCLUSIVE:
        return isExclusive() ? Boolean.TRUE : Boolean.FALSE;
    }
    return eDynamicGet(eFeature, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(EStructuralFeature eFeature, Object newValue)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__LEXICAL_VALUE:
        setLexicalValue((String)newValue);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ANNOTATION:
        setAnnotation((XSDAnnotation)newValue);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FIXED:
        setFixed(((Boolean)newValue).booleanValue());
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__VALUE:
        setValue((Object)newValue);
        return;
    }
    eDynamicSet(eFeature, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__LEXICAL_VALUE:
        setLexicalValue(LEXICAL_VALUE_EDEFAULT);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ANNOTATION:
        setAnnotation((XSDAnnotation)null);
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FIXED:
        unsetFixed();
        return;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    eDynamicUnset(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__LEXICAL_VALUE:
        return LEXICAL_VALUE_EDEFAULT == null ? lexicalValue != null : !LEXICAL_VALUE_EDEFAULT.equals(lexicalValue);
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FACET_NAME:
        return FACET_NAME_EDEFAULT == null ? getFacetName() != null : !FACET_NAME_EDEFAULT.equals(getFacetName());
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__EFFECTIVE_VALUE:
        return EFFECTIVE_VALUE_EDEFAULT == null ? getEffectiveValue() != null : !EFFECTIVE_VALUE_EDEFAULT.equals(getEffectiveValue());
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__ANNOTATION:
        return annotation != null;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__SIMPLE_TYPE_DEFINITION:
        return getSimpleTypeDefinition() != null;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__FIXED:
        return isSetFixed();
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__INCLUSIVE:
        return isInclusive() != INCLUSIVE_EDEFAULT;
      case XSDPackage.XSD_MIN_EXCLUSIVE_FACET__EXCLUSIVE:
        return isExclusive() != EXCLUSIVE_EDEFAULT;
    }
    return eDynamicIsSet(eFeature);
  }

  public Element createElement()
  {
    Element newElement = createElement(XSDConstants.MINEXCLUSIVE_ELEMENT);
    setElement(newElement);
    return newElement;
  }

  protected boolean analyze()
  {
    super.analyze();
    String theLexicalValue = getLexicalValue();
    Object newValue = null;
    if (theLexicalValue != null)
    {
      XSDSimpleTypeDefinition xsdSimpleTypeDefinition = (XSDSimpleTypeDefinition)getContainer();
      if (xsdSimpleTypeDefinition != null)
      {
        try
        {
          newValue = xsdSimpleTypeDefinition.getValue(theLexicalValue);
        }
        catch (RuntimeException exception)
        {
        }
      }
    }

    if (newValue == null ? getValue() != null : !newValue.equals(getValue()))
    {
      setValue(newValue);
    }

    return true;
  }

  protected void changeAttribute(EAttribute eAttribute)
  {
    super.changeAttribute(eAttribute);
    if (eAttribute == XSDPackage.eINSTANCE.getXSDFacet_LexicalValue())
    {
      traverseToRootForAnalysis();
    }
  }

  public boolean isConstraintSatisfied(Object value)
  {
    XSDSimpleTypeDefinition xsdSimpleTypeDefinition = (XSDSimpleTypeDefinition)getContainer();
    if (xsdSimpleTypeDefinition != null)
    {
      return xsdSimpleTypeDefinition.compareValues(value, getValue()) > 0;
    }

    return false;
  }

  public Object getEffectiveValue()
  {
    return getValue();
  }

  public boolean isExclusive()
  {
    return true;
  }

  public XSDConcreteComponent cloneConcreteComponent(boolean deep, boolean shareDOM)
  {
    XSDMinExclusiveFacetImpl clonedMinExclusiveFacet =
      (XSDMinExclusiveFacetImpl)getXSDFactory().createXSDMinExclusiveFacet();
    clonedMinExclusiveFacet.isReconciling = true;

    if (getLexicalValue() != null)
    {
      clonedMinExclusiveFacet.setLexicalValue(getLexicalValue());
    }
    if (isSetFixed())
    {
      clonedMinExclusiveFacet.setFixed(isFixed());
    }

    if (deep)
    {
      if (getAnnotation() != null)
      {
        clonedMinExclusiveFacet.setAnnotation((XSDAnnotation)getAnnotation().cloneConcreteComponent(deep, shareDOM));
      }
    }

    if (shareDOM && getElement() != null)
    {
      clonedMinExclusiveFacet.setElement(getElement());
    }

    clonedMinExclusiveFacet.isReconciling = shareDOM;
    return clonedMinExclusiveFacet;
  }
} 
