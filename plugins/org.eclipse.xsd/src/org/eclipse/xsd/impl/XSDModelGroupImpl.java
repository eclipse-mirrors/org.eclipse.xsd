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
 * $Id: XSDModelGroupImpl.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDFactory;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xsd.impl.XSDModelGroupImpl#getCompositor <em>Compositor</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDModelGroupImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDModelGroupImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDModelGroupImpl#getParticles <em>Particles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSDModelGroupImpl 
  extends XSDTermImpl 
  implements XSDModelGroup
{
  /**
   * The default value of the '{@link #getCompositor() <em>Compositor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompositor()
   * @generated
   * @ordered
   */
  protected static final XSDCompositor COMPOSITOR_EDEFAULT = XSDCompositor.ALL_LITERAL;

  /**
   * The cached value of the '{@link #getCompositor() <em>Compositor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompositor()
   * @generated
   * @ordered
   */
  protected XSDCompositor compositor = COMPOSITOR_EDEFAULT;

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
   * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContents()
   * @generated
   * @ordered
   */
  protected EList contents = null;

  /**
   * The cached value of the '{@link #getParticles() <em>Particles</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParticles()
   * @generated
   * @ordered
   */
  protected EList particles = null;

  public static XSDModelGroup createModelGroup(Node node)
  {
    switch (XSDConstants.nodeType(node))
    {
      case XSDConstants.ALL_ELEMENT:
      {
        XSDModelGroup xsdModelGroup = XSDFactory.eINSTANCE.createXSDModelGroup();
        xsdModelGroup.setCompositor(XSDCompositor.ALL_LITERAL);
        xsdModelGroup.setElement((Element)node);
        return xsdModelGroup;
      }
      case XSDConstants.CHOICE_ELEMENT:
      {
        XSDModelGroup xsdModelGroup = XSDFactory.eINSTANCE.createXSDModelGroup();
        xsdModelGroup.setCompositor(XSDCompositor.CHOICE_LITERAL);
        xsdModelGroup.setElement((Element)node);
        return xsdModelGroup;
      }
      case XSDConstants.SEQUENCE_ELEMENT:
      {
        XSDModelGroup xsdModelGroup = XSDFactory.eINSTANCE.createXSDModelGroup();
        xsdModelGroup.setCompositor(XSDCompositor.SEQUENCE_LITERAL);
        xsdModelGroup.setElement((Element)node);
        return xsdModelGroup;
      }
    }

    return null;
  }

  protected XSDModelGroupImpl() 
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
    return XSDPackage.eINSTANCE.getXSDModelGroup();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDCompositor getCompositor()
  {
    return compositor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompositor(XSDCompositor newCompositor)
  {
    XSDCompositor oldCompositor = compositor;
    compositor = newCompositor == null ? COMPOSITOR_EDEFAULT : newCompositor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_MODEL_GROUP__COMPOSITOR, oldCompositor, compositor));
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
        msgs = ((InternalEObject)annotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_MODEL_GROUP__ANNOTATION, null, msgs);
      if (newAnnotation != null)
        msgs = ((InternalEObject)newAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XSDPackage.XSD_MODEL_GROUP__ANNOTATION, null, msgs);
      msgs = basicSetAnnotation(newAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_MODEL_GROUP__ANNOTATION, newAnnotation, newAnnotation));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_MODEL_GROUP__ANNOTATION, oldAnnotation, newAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getContents()
  {
    if (contents == null)
    {
      contents = new EObjectContainmentEList(XSDParticle.class, this, XSDPackage.XSD_MODEL_GROUP__CONTENTS);
    }
    return contents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getParticles()
  {
    if (particles == null)
    {
      particles = new EObjectEList(XSDParticle.class, this, XSDPackage.XSD_MODEL_GROUP__PARTICLES);
    }
    return particles;
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
        case XSDPackage.XSD_MODEL_GROUP__DIAGNOSTICS:
          return ((InternalEList)getDiagnostics()).basicRemove(otherEnd, msgs);
        case XSDPackage.XSD_MODEL_GROUP__ANNOTATION:
          return basicSetAnnotation(null, msgs);
        case XSDPackage.XSD_MODEL_GROUP__CONTENTS:
          return ((InternalEList)getContents()).basicRemove(otherEnd, msgs);
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
      case XSDPackage.XSD_MODEL_GROUP__ELEMENT:
        return getElement();
      case XSDPackage.XSD_MODEL_GROUP__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_MODEL_GROUP__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_MODEL_GROUP__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_MODEL_GROUP__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_MODEL_GROUP__COMPOSITOR:
        return getCompositor();
      case XSDPackage.XSD_MODEL_GROUP__ANNOTATION:
        return getAnnotation();
      case XSDPackage.XSD_MODEL_GROUP__CONTENTS:
        return getContents();
      case XSDPackage.XSD_MODEL_GROUP__PARTICLES:
        return getParticles();
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
      case XSDPackage.XSD_MODEL_GROUP__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_MODEL_GROUP__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_MODEL_GROUP__COMPOSITOR:
        setCompositor((XSDCompositor)newValue);
        return;
      case XSDPackage.XSD_MODEL_GROUP__ANNOTATION:
        setAnnotation((XSDAnnotation)newValue);
        return;
      case XSDPackage.XSD_MODEL_GROUP__CONTENTS:
        getContents().clear();
        getContents().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_MODEL_GROUP__PARTICLES:
        getParticles().clear();
        getParticles().addAll((Collection)newValue);
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
      case XSDPackage.XSD_MODEL_GROUP__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_MODEL_GROUP__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_MODEL_GROUP__COMPOSITOR:
        setCompositor(COMPOSITOR_EDEFAULT);
        return;
      case XSDPackage.XSD_MODEL_GROUP__ANNOTATION:
        setAnnotation((XSDAnnotation)null);
        return;
      case XSDPackage.XSD_MODEL_GROUP__CONTENTS:
        getContents().clear();
        return;
      case XSDPackage.XSD_MODEL_GROUP__PARTICLES:
        getParticles().clear();
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
      case XSDPackage.XSD_MODEL_GROUP__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_MODEL_GROUP__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_MODEL_GROUP__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_MODEL_GROUP__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_MODEL_GROUP__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_MODEL_GROUP__COMPOSITOR:
        return compositor != COMPOSITOR_EDEFAULT;
      case XSDPackage.XSD_MODEL_GROUP__ANNOTATION:
        return annotation != null;
      case XSDPackage.XSD_MODEL_GROUP__CONTENTS:
        return contents != null && !contents.isEmpty();
      case XSDPackage.XSD_MODEL_GROUP__PARTICLES:
        return particles != null && !particles.isEmpty();
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
    result.append(" (compositor: ");
    result.append(compositor);
    result.append(')');
    return result.toString();
  }

  public Element createElement()
  {
    XSDCompositor theCompositor = getCompositor();
    Element newElement = 
      createElement
        (XSDCompositor.ALL_LITERAL == theCompositor ?
           XSDConstants.ALL_ELEMENT :
           XSDCompositor.CHOICE_LITERAL == theCompositor ?
             XSDConstants.CHOICE_ELEMENT :
             XSDConstants.SEQUENCE_ELEMENT);

    setElement(newElement);
    for (Iterator contents = getContents().iterator(); contents.hasNext(); )
    {
      XSDParticle xsdParticle = (XSDParticle)contents.next();
      Element newParticleElement = ((XSDConcreteComponentImpl)xsdParticle).createElement();
      newElement.appendChild(newParticleElement);
    }
    return newElement;
  }

  protected void patch()
  {
    super.patch();

    List newParticles = new ArrayList(getContents());
    Collection remainingParticles = new ArrayList(getParticles());
    for (ListIterator particles = newParticles.listIterator(); particles.hasNext(); )
    {
      XSDParticle xsdParticle = (XSDParticle)particles.next();
      if (xsdParticle.getMaxOccurs() == 0)
      {
        particles.remove();
        remainingParticles.add(xsdParticle);
      }
      else
      {
        remainingParticles.remove(xsdParticle);
      }
    }

    if (!remainingParticles.isEmpty())
    {
      getParticles().removeAll(remainingParticles);
    }

    setListContentAndOrder(getParticles(), newParticles);
  }

  public void validate()
  {
    super.validate();

    boolean hasBounds = !(getContainer() instanceof XSDModelGroupDefinition);
    String anchor = null;
    String contentType = null;
    switch (getCompositor().getValue())
    {
      case XSDCompositor.ALL:
      {
        anchor = "element-all";
        contentType = "all";

        for (Iterator i = getContents().iterator(); i.hasNext(); )
        {
          XSDParticle xsdParticle = (XSDParticle)i.next();
          switch (xsdParticle.getMaxOccurs())
          {
            case 0:
            case 1:
            {
              break;
            }
            default:
            {
              createDiagnostic(XSDDiagnosticSeverity.ERROR_LITERAL, "cos-all-limited.2");
            }
          }
        }
        break;
      }
      case XSDCompositor.SEQUENCE:
      {
        anchor = "element-sequence";
        contentType = "explicitGroup";
        break;
      }
      case XSDCompositor.CHOICE:
      {
        anchor = "element-choice";
        contentType = "explicitGroup";
        break;
      }
    }

    Element theElement = getElement();
    if (theElement != null)
    {
      String [] attributes =
        hasBounds ?
          new String []
          {
            XSDConstants.ID_ATTRIBUTE,
            XSDConstants.MAXOCCURS_ATTRIBUTE,
            XSDConstants.MINOCCURS_ATTRIBUTE
          } :
          new String []
          {
            XSDConstants.ID_ATTRIBUTE,
          };

      checkAttributes(XSDConstants.PART1, anchor, theElement, attributes);
      checkBuiltInTypeConstraint("ID", null, XSDConstants.PART1, anchor, theElement, XSDConstants.ID_ATTRIBUTE, false);

      if (hasBounds)
      {
        checkAttributeTypeConstraint
          (contentType,
           "maxOccurs",
           null,
           XSDConstants.PART1,
           anchor,
           theElement,
           XSDConstants.MAXOCCURS_ATTRIBUTE,
           false);

        checkAttributeTypeConstraint
          (contentType,
           "minOccurs",
           null,
           XSDConstants.PART1,
           anchor,
           theElement,
           XSDConstants.MINOCCURS_ATTRIBUTE,
           false);
      }

      checkComplexContent(contentType, XSDConstants.PART1, anchor, theElement);
    }
    else
    {
      // EATM validate synthesized models too
    }
  }

  public void validateRoot()
  {
    XSDConcreteComponent diagnosticTarget = this;
    XSDParticle xsdParticle;
    if (getContainer() instanceof XSDParticle)
    {
      xsdParticle = (XSDParticle)getContainer();
      if (xsdParticle.eContainmentFeature() == XSDPackage.eINSTANCE.getXSDComplexTypeDefinition_SyntheticParticle())
      {
        diagnosticTarget = xsdParticle.getContainer();
      }
    }
    else
    {
      xsdParticle = XSDFactory.eINSTANCE.createXSDParticle();
      xsdParticle.setTerm(this);
    }

    XSDParticleImpl.XSDNFA dfa = (XSDParticleImpl.XSDNFA)xsdParticle.getDFA();
    Collection diagnostics = dfa.getDiagnostics();
    if (!diagnostics.isEmpty())
    {
      for (Iterator i = diagnostics.iterator(); i.hasNext(); )
      {
        XSDDiagnostic xsdDiagnostic = (XSDDiagnostic)i.next();
        xsdDiagnostic.setPrimaryComponent(diagnosticTarget);
        xsdDiagnostic.setNode(diagnosticTarget.getElement());
      }
      getDiagnostics().addAll(diagnostics);
    }
  }

  protected boolean isUpdatingDOM()
  {
    return
      super.isUpdatingDOM() ||
        getContainer() instanceof XSDConcreteComponentImpl &&
          ((XSDConcreteComponentImpl)getContainer()).isUpdatingDOM();
  }

  protected void handleUnreconciledElement(Element child, List newContents, List remainingContents)
  {
    XSDParticle xsdParticle = XSDParticleImpl.createParticle(child);
    if (xsdParticle != null)
    {
      newContents.add(xsdParticle);
    }
    else
    {
      XSDAnnotation xsdAnnotation = XSDAnnotationImpl.createAnnotation(child);
      if (xsdAnnotation != null)
      {
        if (newContents.isEmpty())
        {
          newContents.add(xsdAnnotation);
        }
      }
    }
  }

  protected void handleReconciliation(List newContents, List remainingContents)
  {
    handleAnnotationReconciliation(XSDPackage.eINSTANCE.getXSDModelGroup_Annotation(), newContents, remainingContents);

    if (!remainingContents.isEmpty())
    {
      getContents().removeAll(remainingContents);
    }

    if (!newContents.isEmpty())
    {
      setListContentAndOrder(getContents(), newContents);
    }
  }

  protected void changeAttribute(EAttribute eAttribute)
  {
    super.changeAttribute(eAttribute);
    Element theElement = getElement();
    if (eAttribute == null || eAttribute == XSDPackage.eINSTANCE.getXSDModelGroup_Compositor())
    {
      if (theElement != null && eAttribute != null && !isReconciling)
      {
        XSDCompositor theCompositor = getCompositor();
        Element newElement =
          createElement
            (XSDCompositor.ALL_LITERAL == theCompositor ?
               XSDConstants.ALL_ELEMENT :
               XSDCompositor.CHOICE_LITERAL == theCompositor ?
                 XSDConstants.CHOICE_ELEMENT :
                 XSDConstants.SEQUENCE_ELEMENT);

        forceReplace(newElement, theElement);
        setElement(newElement);

        XSDConcreteComponentImpl container = (XSDConcreteComponentImpl)getContainer();
        if (container instanceof XSDParticle)
        {
          ((XSDParticle)container).setElement(newElement);
          container.changeAttribute(null);
        }
      }
    }
  }

  protected void adoptContent(EReference eReference, XSDConcreteComponent xsdConcreteComponent)
  {
    super.adoptContent(eReference, xsdConcreteComponent);
    if (eReference == XSDPackage.eINSTANCE.getXSDModelGroup_Contents())
    {
      traverseToRootForPatching();
    }
  }

  protected void orphanContent(EReference eReference, XSDConcreteComponent xsdConcreteComponent)
  {
    super.orphanContent(eReference, xsdConcreteComponent);
    if (eReference == XSDPackage.eINSTANCE.getXSDModelGroup_Contents())
    {
      traverseToRootForPatching();
    }
  }

  public XSDConcreteComponent cloneConcreteComponent(boolean deep, boolean shareDOM)
  {
    XSDModelGroupImpl clonedModelGroup =
      (XSDModelGroupImpl)getXSDFactory().createXSDModelGroup();
    clonedModelGroup.isReconciling = true;

    clonedModelGroup.setCompositor(getCompositor());

    if (deep)
    {
      if (getAnnotation() != null)
      {
        clonedModelGroup.setAnnotation((XSDAnnotation)getAnnotation().cloneConcreteComponent(deep, shareDOM));
      }
      if (!getContents().isEmpty())
      {
        clonedModelGroup.getContents().addAll(cloneConcreteComponents(getContents(), true, shareDOM));
      }
    }

    if (shareDOM && getElement() != null)
    {
      clonedModelGroup.setElement(getElement());
    }

    clonedModelGroup.isReconciling = shareDOM;
    return clonedModelGroup;
  }
}
