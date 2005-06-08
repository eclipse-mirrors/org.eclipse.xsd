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
 * $Id: XSDIdentityConstraintDefinitionImpl.java,v 1.2.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.Collection;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDXPathDefinition;
import org.eclipse.xsd.XSDXPathVariety;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identity Constraint Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl#getIdentityConstraintCategory <em>Identity Constraint Category</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl#getReferencedKey <em>Referenced Key</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDIdentityConstraintDefinitionImpl#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSDIdentityConstraintDefinitionImpl 
  extends XSDNamedComponentImpl 
  implements XSDIdentityConstraintDefinition
{
  /**
   * The default value of the '{@link #getIdentityConstraintCategory() <em>Identity Constraint Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentityConstraintCategory()
   * @generated
   * @ordered
   */
  protected static final XSDIdentityConstraintCategory IDENTITY_CONSTRAINT_CATEGORY_EDEFAULT = XSDIdentityConstraintCategory.KEY_LITERAL;

  /**
   * The cached value of the '{@link #getIdentityConstraintCategory() <em>Identity Constraint Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentityConstraintCategory()
   * @generated
   * @ordered
   */
  protected XSDIdentityConstraintCategory identityConstraintCategory = IDENTITY_CONSTRAINT_CATEGORY_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected XSDAnnotation annotation = null;

  /**
   * The cached value of the '{@link #getReferencedKey() <em>Referenced Key</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferencedKey()
   * @generated
   * @ordered
   */
  protected XSDIdentityConstraintDefinition referencedKey = null;

  /**
   * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelector()
   * @generated
   * @ordered
   */
  protected XSDXPathDefinition selector = null;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList fields = null;

  public static XSDIdentityConstraintDefinition createIdentityConstraintDefinition(Node node)
  {
    switch (XSDConstants.nodeType(node))
    {
      case XSDConstants.KEY_ELEMENT:
      case XSDConstants.KEYREF_ELEMENT:
      case XSDConstants.UNIQUE_ELEMENT:
      {
        XSDIdentityConstraintDefinition xsdIdentityConstraintDefinition = 
          XSDFactory.eINSTANCE.createXSDIdentityConstraintDefinition();
        xsdIdentityConstraintDefinition.setElement((Element)node);
        return xsdIdentityConstraintDefinition;
      }
    }

    return null;
  }

  protected XSDIdentityConstraintDefinitionImpl() 
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
    return XSDPackage.eINSTANCE.getXSDIdentityConstraintDefinition();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDIdentityConstraintCategory getIdentityConstraintCategory()
  {
    return identityConstraintCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentityConstraintCategory(XSDIdentityConstraintCategory newIdentityConstraintCategory)
  {
    XSDIdentityConstraintCategory oldIdentityConstraintCategory = identityConstraintCategory;
    identityConstraintCategory = newIdentityConstraintCategory == null ? IDENTITY_CONSTRAINT_CATEGORY_EDEFAULT : newIdentityConstraintCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__IDENTITY_CONSTRAINT_CATEGORY, oldIdentityConstraintCategory, identityConstraintCategory));
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
        msgs = ((InternalEObject)annotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION, null, msgs);
      if (newAnnotation != null)
        msgs = ((InternalEObject)newAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION, null, msgs);
      msgs = basicSetAnnotation(newAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION, newAnnotation, newAnnotation));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION, oldAnnotation, newAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDIdentityConstraintDefinition getReferencedKey()
  {
    return referencedKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferencedKey(XSDIdentityConstraintDefinition newReferencedKey)
  {
    XSDIdentityConstraintDefinition oldReferencedKey = referencedKey;
    referencedKey = newReferencedKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__REFERENCED_KEY, oldReferencedKey, referencedKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDXPathDefinition getSelector()
  {
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelector(XSDXPathDefinition newSelector)
  {
    if (newSelector != selector)
    {
      NotificationChain msgs = null;
      if (selector != null)
        msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR, null, msgs);
      if (newSelector != null)
        msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR, null, msgs);
      msgs = basicSetSelector(newSelector, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR, newSelector, newSelector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSelector(XSDXPathDefinition newSelector, NotificationChain msgs)
  {
    XSDXPathDefinition oldSelector = selector;
    selector = newSelector;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR, oldSelector, newSelector);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getFields()
  {
    if (fields == null)
    {
      fields = new EObjectContainmentEList(XSDXPathDefinition.class, this, XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS);
    }
    return fields;
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
        case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__DIAGNOSTICS:
          return ((InternalEList)getDiagnostics()).basicRemove(otherEnd, msgs);
        case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION:
          return basicSetAnnotation(null, msgs);
        case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR:
          return basicSetSelector(null, msgs);
        case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS:
          return ((InternalEList)getFields()).basicRemove(otherEnd, msgs);
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
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ELEMENT:
        return getElement();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__NAME:
        return getName();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__TARGET_NAMESPACE:
        return getTargetNamespace();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ALIAS_NAME:
        return getAliasName();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__URI:
        return getURI();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ALIAS_URI:
        return getAliasURI();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__QNAME:
        return getQName();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__IDENTITY_CONSTRAINT_CATEGORY:
        return getIdentityConstraintCategory();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION:
        return getAnnotation();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__REFERENCED_KEY:
        return getReferencedKey();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR:
        return getSelector();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS:
        return getFields();
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
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__TARGET_NAMESPACE:
        setTargetNamespace((String)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__IDENTITY_CONSTRAINT_CATEGORY:
        setIdentityConstraintCategory((XSDIdentityConstraintCategory)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION:
        setAnnotation((XSDAnnotation)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__REFERENCED_KEY:
        setReferencedKey((XSDIdentityConstraintDefinition)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR:
        setSelector((XSDXPathDefinition)newValue);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS:
        getFields().clear();
        getFields().addAll((Collection)newValue);
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
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__TARGET_NAMESPACE:
        setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__IDENTITY_CONSTRAINT_CATEGORY:
        setIdentityConstraintCategory(IDENTITY_CONSTRAINT_CATEGORY_EDEFAULT);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION:
        setAnnotation((XSDAnnotation)null);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__REFERENCED_KEY:
        setReferencedKey((XSDIdentityConstraintDefinition)null);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR:
        setSelector((XSDXPathDefinition)null);
        return;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS:
        getFields().clear();
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
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__TARGET_NAMESPACE:
        return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ALIAS_NAME:
        return ALIAS_NAME_EDEFAULT == null ? getAliasName() != null : !ALIAS_NAME_EDEFAULT.equals(getAliasName());
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__URI:
        return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ALIAS_URI:
        return ALIAS_URI_EDEFAULT == null ? getAliasURI() != null : !ALIAS_URI_EDEFAULT.equals(getAliasURI());
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__QNAME:
        return QNAME_EDEFAULT == null ? getQName() != null : !QNAME_EDEFAULT.equals(getQName());
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__IDENTITY_CONSTRAINT_CATEGORY:
        return identityConstraintCategory != IDENTITY_CONSTRAINT_CATEGORY_EDEFAULT;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__ANNOTATION:
        return annotation != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__REFERENCED_KEY:
        return referencedKey != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__SELECTOR:
        return selector != null;
      case XSDPackage.XSD_IDENTITY_CONSTRAINT_DEFINITION__FIELDS:
        return fields != null && !fields.isEmpty();
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
    result.append(" (identityConstraintCategory: ");
    result.append(identityConstraintCategory);
    result.append(')');
    return result.toString();
  }

  public Element createElement()
  {
    Element newElement = 
      createElement
        (XSDIdentityConstraintCategory.UNIQUE_LITERAL == getIdentityConstraintCategory() ?
           XSDConstants.UNIQUE_ELEMENT :
           XSDIdentityConstraintCategory.KEYREF_LITERAL == getIdentityConstraintCategory() ?
           XSDConstants.KEYREF_ELEMENT :
           XSDConstants.KEY_ELEMENT);
    setElement(newElement);
    return newElement;
  }

  protected void patch()
  {
    super.patch();
    XSDIdentityConstraintDefinition theReferencedKey = getReferencedKey();
    if (theReferencedKey != null)
    {
      XSDIdentityConstraintDefinition newReferencedKey =
        resolveIdentityConstraintDefinition(theReferencedKey.getTargetNamespace(), theReferencedKey.getName());
      if (newReferencedKey != theReferencedKey)
      {
        setReferencedKey(newReferencedKey);
      }
    }
  }

  public void validate()
  {
    super.validate();

    String anchor = null;
    String [] attributes = null;
    XSDComplexTypeDefinition xsdComplexTypeDefinition = null;
    switch (getIdentityConstraintCategory().getValue())
    {
      case XSDIdentityConstraintCategory.KEY:
      {
        anchor = "element-key";
        attributes =
          new String []
          {
            XSDConstants.ID_ATTRIBUTE,
            XSDConstants.NAME_ATTRIBUTE
          };

        xsdComplexTypeDefinition = getSchema().getSchemaForSchema().resolveComplexTypeDefinition("keybase");

        break;
      }
      case XSDIdentityConstraintCategory.KEYREF:
      {
        anchor = "element-keyRef";
        attributes =
          new String []
          {
            XSDConstants.ID_ATTRIBUTE,
            XSDConstants.NAME_ATTRIBUTE,
            XSDConstants.REFER_ATTRIBUTE
          };

        xsdComplexTypeDefinition = 
          (XSDComplexTypeDefinition)getSchema().getSchemaForSchema().resolveElementDeclaration("keyref").getTypeDefinition();

        XSDIdentityConstraintDefinition theReferencedKey = getReferencedKey();
        if (theReferencedKey == null)
        {
          createDiagnostic(XSDDiagnosticSeverity.ERROR_LITERAL, "_UI_UnresolvedIdentityConstraintDefinition_message", "");
        }
        else if (theReferencedKey.getContainer() == null)
        {
          createDiagnostic
            (XSDDiagnosticSeverity.ERROR_LITERAL, "_UI_UnresolvedIdentityConstraintDefinition_message", theReferencedKey.getURI());
        }
        else
        {
          if (theReferencedKey.getFields().size() != getFields().size())
          {
            createDiagnostic(XSDDiagnosticSeverity.ERROR_LITERAL, "c-props-correct.2");
          }
        }

        break;
      }
      case XSDIdentityConstraintCategory.UNIQUE:
      {
        anchor = "element-unique";
        attributes =
          new String []
          {
            XSDConstants.ID_ATTRIBUTE,
            XSDConstants.NAME_ATTRIBUTE
          };

        xsdComplexTypeDefinition = getSchema().getSchemaForSchema().resolveComplexTypeDefinition("keybase");
        break;
      }
    }
    Element theElement = getElement();
    if (theElement != null)
    {
      checkAttributes(XSDConstants.PART1, anchor, theElement, attributes);
      checkComplexContent(xsdComplexTypeDefinition, XSDConstants.PART1, anchor, theElement);
    }

    checkBuiltInTypeConstraint
      ("NCName",
       getName(),
       XSDConstants.PART1,
       anchor,
       theElement,
       XSDConstants.NAME_ATTRIBUTE,
       true);
  }

  protected void reconcileAttributes(Element changedElement)
  {
    super.reconcileAttributes(changedElement);

    if (changedElement == getElement())
    {
      XSDIdentityConstraintCategory newIdentityConstraintCategory = XSDIdentityConstraintCategory.get(changedElement.getLocalName());
      if (newIdentityConstraintCategory != getIdentityConstraintCategory())
      {
        setIdentityConstraintCategory(newIdentityConstraintCategory);
      }

      if (newIdentityConstraintCategory == XSDIdentityConstraintCategory.KEYREF_LITERAL)
      {
        XSDIdentityConstraintDefinition newReferencedKey = null;
        if (changedElement.hasAttributeNS(null, XSDConstants.REFER_ATTRIBUTE))
        {
          newReferencedKey = 
            resolveIdentityConstraintDefinitionURI(XSDConstants.lookupQNameForAttribute(changedElement, XSDConstants.REFER_ATTRIBUTE));
        }

        if (newReferencedKey != getReferencedKey())
        {
          setReferencedKey(newReferencedKey);
        }
      }
    }
  }

  protected void handleUnreconciledElement(Element child, List newContents, List remainingContents)
  {
    XSDXPathDefinition xsdXPathDefinition = XSDXPathDefinitionImpl.createXPathDefinition(child);
    if (xsdXPathDefinition != null)
    {
      newContents.add(xsdXPathDefinition);
    }
    else
    {
      XSDAnnotation xsdAnnotation = XSDAnnotationImpl.createAnnotation(child);
      if (xsdAnnotation != null && newContents.isEmpty())
      {
        newContents.add(xsdAnnotation);
      }
    }
  }

  protected void handleReconciliation(List newContents, List remainingContents)
  {
    handleAnnotationReconciliation(XSDPackage.eINSTANCE.getXSDIdentityConstraintDefinition_Annotation(), newContents, remainingContents);

    XSDXPathDefinition newSelector = null;
    if (!newContents.isEmpty())
    {
      newSelector = (XSDXPathDefinition)newContents.get(0);
      if (XSDXPathVariety.SELECTOR_LITERAL == newSelector.getVariety())
      {
        newContents.remove(0);
      }
      else
      {
        newSelector = null;
      }
    }

    if (newSelector != getSelector())
    {
      remainingContents.remove(getSelector());
      setSelector(newSelector);
    }

    if (!remainingContents.isEmpty())
    {
      getFields().removeAll(remainingContents);
    }

    if (!newContents.isEmpty())
    {
      setListContentAndOrder(getFields(), newContents);
    }
  }

  protected void changeAttribute(EAttribute eAttribute)
  {
    super.changeAttribute(eAttribute);
    Element theElement = getElement();
    if (eAttribute == null || eAttribute == XSDPackage.eINSTANCE.getXSDIdentityConstraintDefinition_IdentityConstraintCategory())
    {
      if (theElement != null && eAttribute != null && !isReconciling)
      {
        Element newElement = 
          createElement
            (XSDIdentityConstraintCategory.UNIQUE_LITERAL == getIdentityConstraintCategory() ?
               XSDConstants.UNIQUE_ELEMENT :
               XSDIdentityConstraintCategory.KEYREF_LITERAL == getIdentityConstraintCategory() ?
               XSDConstants.KEYREF_ELEMENT :
               XSDConstants.KEY_ELEMENT);

        forceReplace(newElement, theElement);
        setElement(newElement);
      }
    }
  }

  protected void adoptBy(XSDSchema xsdSchema)
  {
    if (!xsdSchema.getIdentityConstraintDefinitions().contains(this))
    {
      XSDNamedComponentImpl.addToSortedList(xsdSchema.getIdentityConstraintDefinitions(), this);
    }
    super.adoptBy(xsdSchema);
  }

  protected void orphanBy(XSDSchema xsdSchema)
  {
    xsdSchema.getIdentityConstraintDefinitions().remove(this);
    super.orphanBy(xsdSchema);
  }

  protected void changeReference(EReference eReference)
  {
    super.changeReference(eReference);
    Element theElement = getElement();
    if (XSDIdentityConstraintCategory.KEYREF_LITERAL == getIdentityConstraintCategory())
    {
      if (eReference == null || eReference == XSDPackage.eINSTANCE.getXSDIdentityConstraintDefinition_ReferencedKey())
      {
        XSDIdentityConstraintDefinition theReferencedKey = getReferencedKey();
        if (theElement != null)
        {
          niceSetAttributeURIValue(theElement, XSDConstants.REFER_ATTRIBUTE, theReferencedKey == null ? null : theReferencedKey.getURI());
        }
      }
    }
  }

  public XSDConcreteComponent cloneConcreteComponent(boolean deep, boolean shareDOM)
  {
    XSDIdentityConstraintDefinitionImpl clonedIdentityConstraintDefinition =
      (XSDIdentityConstraintDefinitionImpl)getXSDFactory().createXSDIdentityConstraintDefinition();
    clonedIdentityConstraintDefinition.isReconciling = true;

    if (getName() != null)
    {
      clonedIdentityConstraintDefinition.setName(getName());
    }
    clonedIdentityConstraintDefinition.setIdentityConstraintCategory(getIdentityConstraintCategory());

    XSDIdentityConstraintDefinition theReferencedKey = getReferencedKey();
    if (theReferencedKey != null)
    {
      clonedIdentityConstraintDefinition.setReferencedKey
        (createUnresolvedIdentityConstraintDefinition
           (theReferencedKey.getTargetNamespace(), theReferencedKey.getName()));
    }

    if (deep)
    {
      if (getAnnotation() != null)
      {
        clonedIdentityConstraintDefinition.setAnnotation((XSDAnnotation)getAnnotation().cloneConcreteComponent(deep, shareDOM));
      }
      if (getSelector() != null)
      {
        clonedIdentityConstraintDefinition.setSelector((XSDXPathDefinition)getSelector().cloneConcreteComponent(deep, shareDOM));
      }
      if (!getFields().isEmpty())
      {
        clonedIdentityConstraintDefinition.getFields().addAll(cloneConcreteComponents(getFields(), deep, shareDOM));
      }
    }

    if (shareDOM && getElement() != null)
    {
      clonedIdentityConstraintDefinition.setElement(getElement());
    }

    clonedIdentityConstraintDefinition.isReconciling = shareDOM;
    return clonedIdentityConstraintDefinition;
  }
}
