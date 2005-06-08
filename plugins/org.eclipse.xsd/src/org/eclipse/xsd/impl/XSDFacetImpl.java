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
 * $Id: XSDFacetImpl.java,v 1.2.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDFacet;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xsd.impl.XSDFacetImpl#getLexicalValue <em>Lexical Value</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDFacetImpl#getFacetName <em>Facet Name</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDFacetImpl#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDFacetImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDFacetImpl#getSimpleTypeDefinition <em>Simple Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XSDFacetImpl 
  extends XSDComponentImpl 
  implements XSDFacet
{
  /**
   * The default value of the '{@link #getLexicalValue() <em>Lexical Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexicalValue()
   * @generated
   * @ordered
   */
  protected static final String LEXICAL_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLexicalValue() <em>Lexical Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexicalValue()
   * @generated
   * @ordered
   */
  protected String lexicalValue = LEXICAL_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getFacetName() <em>Facet Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFacetName()
   * @generated
   * @ordered
   */
  protected static final String FACET_NAME_EDEFAULT = null;

  /**
   * The default value of the '{@link #getEffectiveValue() <em>Effective Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectiveValue()
   * @generated
   * @ordered
   */
  protected static final Object EFFECTIVE_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected XSDAnnotation annotation = null;

  protected XSDFacetImpl() 
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
    return XSDPackage.eINSTANCE.getXSDFacet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLexicalValue()
  {
    return lexicalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLexicalValue(String newLexicalValue)
  {
    String oldLexicalValue = lexicalValue;
    lexicalValue = newLexicalValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_FACET__LEXICAL_VALUE, oldLexicalValue, lexicalValue));
  }

  public void validate()
  {
    super.validate();

    Element theElement = getElement();
    if (theElement != null)
    {
      checkComplexContent("annotated", XSDConstants.PART2, "element-" + getFacetName(), theElement);
    }
    validateValue();
  }

  protected void validateValue()
  {
  }

  protected void reconcileAttributes(Element changedElement)
  {
    super.reconcileAttributes(changedElement);

    if (changedElement.hasAttributeNS(null, XSDConstants.VALUE_ATTRIBUTE))
    {
      String newLexicalValue = changedElement.getAttributeNS(null, XSDConstants.VALUE_ATTRIBUTE);
      if (newLexicalValue == null || !newLexicalValue.equals(getLexicalValue()))
      {
        setLexicalValue(newLexicalValue);
      }
    }
    else if (getLexicalValue() != null)
    {
      setLexicalValue(null);
    }
  }

  protected void handleUnreconciledElement(Element child, List newContents, List remainingContents)
  {
    if (XSDConstants.nodeType(child) == XSDConstants.ANNOTATION_ELEMENT)
    {
      XSDAnnotation xsdAnnotation = XSDAnnotationImpl.createAnnotation(child);
      newContents.add(xsdAnnotation);
    }
  }

  protected void handleReconciliation(List newContents, List remainingContents)
  {
    handleAnnotationReconciliation(XSDPackage.eINSTANCE.getXSDFacet_Annotation(), newContents, remainingContents);
  }

  protected void changeAttribute(EAttribute eAttribute)
  {
    if (isReconciling)
    {
      return;
    }

    super.changeAttribute(eAttribute);
    Element theElement = getElement();
    if (theElement != null)
    {
      if (eAttribute == null || eAttribute == XSDPackage.eINSTANCE.getXSDFacet_LexicalValue())
      {
        niceSetAttribute(theElement, XSDConstants.VALUE_ATTRIBUTE, getLexicalValue());
      }
    }
  }

  public String getFacetName()
  {
    String name = eClass().getName();
    return Character.toLowerCase(name.charAt(3)) + name.substring(4, name.length() - 5);
  }

  public Object getEffectiveValue()
  {
    return null;
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDAnnotation getAnnotation()
  {
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotation(XSDAnnotation newAnnotation)
  {
    if (newAnnotation != annotation)
    {
      NotificationChain msgs = null;
      if (annotation != null)
        msgs = ((InternalEObject)annotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_FACET__ANNOTATION, null, msgs);
      if (newAnnotation != null)
        msgs = ((InternalEObject)newAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_FACET__ANNOTATION, null, msgs);
      msgs = basicSetAnnotation(newAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_FACET__ANNOTATION, newAnnotation, newAnnotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnnotation(XSDAnnotation newAnnotation, NotificationChain msgs)
  {
    XSDAnnotation oldAnnotation = annotation;
    annotation = newAnnotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_FACET__ANNOTATION, oldAnnotation, newAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public XSDSimpleTypeDefinition getSimpleTypeDefinition() 
  {
    XSDConcreteComponent result = getContainer();
    return result instanceof XSDSimpleTypeDefinition ? (XSDSimpleTypeDefinition)result : null;
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
        case XSDPackage.XSD_FACET__DIAGNOSTICS:
          return ((InternalEList)getDiagnostics()).basicRemove(otherEnd, msgs);
        case XSDPackage.XSD_FACET__ANNOTATION:
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
      case XSDPackage.XSD_FACET__ELEMENT:
        return getElement();
      case XSDPackage.XSD_FACET__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_FACET__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_FACET__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_FACET__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_FACET__LEXICAL_VALUE:
        return getLexicalValue();
      case XSDPackage.XSD_FACET__FACET_NAME:
        return getFacetName();
      case XSDPackage.XSD_FACET__EFFECTIVE_VALUE:
        return getEffectiveValue();
      case XSDPackage.XSD_FACET__ANNOTATION:
        return getAnnotation();
      case XSDPackage.XSD_FACET__SIMPLE_TYPE_DEFINITION:
        return getSimpleTypeDefinition();
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
      case XSDPackage.XSD_FACET__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_FACET__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_FACET__LEXICAL_VALUE:
        setLexicalValue((String)newValue);
        return;
      case XSDPackage.XSD_FACET__ANNOTATION:
        setAnnotation((XSDAnnotation)newValue);
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
      case XSDPackage.XSD_FACET__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_FACET__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_FACET__LEXICAL_VALUE:
        setLexicalValue(LEXICAL_VALUE_EDEFAULT);
        return;
      case XSDPackage.XSD_FACET__ANNOTATION:
        setAnnotation((XSDAnnotation)null);
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
      case XSDPackage.XSD_FACET__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_FACET__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_FACET__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_FACET__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_FACET__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_FACET__LEXICAL_VALUE:
        return LEXICAL_VALUE_EDEFAULT == null ? lexicalValue != null : !LEXICAL_VALUE_EDEFAULT.equals(lexicalValue);
      case XSDPackage.XSD_FACET__FACET_NAME:
        return FACET_NAME_EDEFAULT == null ? getFacetName() != null : !FACET_NAME_EDEFAULT.equals(getFacetName());
      case XSDPackage.XSD_FACET__EFFECTIVE_VALUE:
        return EFFECTIVE_VALUE_EDEFAULT == null ? getEffectiveValue() != null : !EFFECTIVE_VALUE_EDEFAULT.equals(getEffectiveValue());
      case XSDPackage.XSD_FACET__ANNOTATION:
        return annotation != null;
      case XSDPackage.XSD_FACET__SIMPLE_TYPE_DEFINITION:
        return getSimpleTypeDefinition() != null;
    }
    return eDynamicIsSet(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (lexicalValue: ");
    result.append(lexicalValue);
    result.append(')');
    return result.toString();
  }

}
