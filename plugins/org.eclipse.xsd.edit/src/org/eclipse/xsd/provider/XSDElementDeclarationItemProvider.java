/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XSDElementDeclarationItemProvider.java,v 1.1 2004/03/06 18:00:11 marcelop Exp $
 */
package org.eclipse.xsd.provider;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintCategory;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDParticle;


/**
 * This is the item provider adpater for a {@link org.eclipse.xsd.XSDElementDeclaration} object.
 */
public class XSDElementDeclarationItemProvider
  extends XSDFeatureItemProvider
  implements 
    IEditingDomainItemProvider,
    IStructuredItemContentProvider, 
    ITreeItemContentProvider, 
    IItemLabelProvider, 
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   */
  public XSDElementDeclarationItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   */
  public List getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      createLexicalValuePropertyDescriptor(object);
      createConstraintPropertyDescriptor(object);
      createScopePropertyDescriptor(object);
      createNillablePropertyDescriptor(object);
      createDisallowedSubstitutionsPropertyDescriptor(object);
      createSubstitutionGroupExclusionsPropertyDescriptor(object);
      createAbstractPropertyDescriptor(object);
      createTypeDefinitionPropertyDescriptor(object);
      createSubstitutionGroupAffiliationPropertyDescriptor(object);
      createAnnotationPropertyDescriptor(object);
      createResolvedElementDeclarationPropertyDescriptor(object);
      createElementFormDefaultPropertyDescriptor(object);
      createLexicalFinalPropertyDescriptor(object);
      createBlockPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  protected static class DelegatingItemPropertyDescriptor extends XSDItemProviderAdapter.ItemPropertyDescriptorWithDefault
  {
    public DelegatingItemPropertyDescriptor
       (AdapterFactory adapterFactory,
        String displayName,
        String description,
        EStructuralFeature feature,
        boolean isSettable,
        Object staticImage)
    {
      super(adapterFactory, displayName, description, feature, isSettable, staticImage);
    }

    public Object getPropertyValue(Object object)
    {
      return super.getPropertyValue(((XSDElementDeclaration)object).getResolvedElementDeclaration());
    }

    public void setPropertyValue(Object object, Object value)
    {
      super.setPropertyValue(((XSDElementDeclaration)object).getResolvedElementDeclaration(), value);
    }

  }

  protected void createNamePropertyDescriptor(Object object)
  {

    // This is for the name feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Name_label"),
         XSDEditPlugin.getString("_UI_Name_description"),
         xsdPackage.getXSDNamedComponent_Name(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public void setPropertyValue(Object o, Object value)
         {
           XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)o;
           if (xsdElementDeclaration.isElementDeclarationReference())
           {
             XSDElementDeclaration newResolvedElementDeclaration = 
               xsdElementDeclaration.resolveElementDeclaration(xsdElementDeclaration.getTargetNamespace(), (String)value);
             EditingDomain editingDomain = getEditingDomain(xsdElementDeclaration);
             if (editingDomain == null)
             {
               xsdElementDeclaration.setResolvedElementDeclaration(newResolvedElementDeclaration);
             }
             else
             {
               editingDomain.getCommandStack().execute
                 (SetCommand.create
                    (editingDomain, 
                     xsdElementDeclaration, 
                     xsdPackage.getXSDElementDeclaration_ResolvedElementDeclaration(), 
                     newResolvedElementDeclaration));
             }
           }
           else
           {
             super.setPropertyValue(o, value);
           }
         }
       });
  }

  protected void createLexicalFinalPropertyDescriptor(Object object)
  {

    // This is for the final feature.
    //
    itemPropertyDescriptors.add
      (new XSDItemProviderAdapter.ItemPropertyDescriptorWithDefault
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Final_label"),
         XSDEditPlugin.getString("_UI_FinalOfElement_description"),
         xsdPackage.getXSDElementDeclaration_LexicalFinal(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return 
             XSDEditPlugin.getString
               ("_UI_DefaultValue_label", new Object [] { ((XSDElementDeclaration)o).getStringLexicalFinal() });
         }
         public Object getPropertyValue(Object o)
         {
           return ((XSDElementDeclaration)o).getStringLexicalFinal();
         }
         public void setPropertyValue(Object o, Object value)
         {
           ((XSDElementDeclaration)o).setStringLexicalFinal((String)value);
         }
         public Collection getChoiceOfValues(Object o)
         {
           Collection result = new ArrayList();
           result.add("");
           result.add("#all");
           result.add("restriction");
           result.add("restriction extension");
           result.add("extension");
           return result;
         }
       });
  }
  protected void createBlockPropertyDescriptor(Object object)
  {

    // This is for the final feature.
    //
    itemPropertyDescriptors.add
      (new XSDItemProviderAdapter.ItemPropertyDescriptorWithDefault
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Block_label"),
         XSDEditPlugin.getString("_UI_BlockOfElement_description"),
         xsdPackage.getXSDElementDeclaration_Block(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return 
             XSDEditPlugin.getString
               ("_UI_DefaultValue_label", new Object [] { ((XSDElementDeclaration)o).getStringBlock() });
         }
         public Object getPropertyValue(Object o)
         {
           return ((XSDElementDeclaration)o).getStringBlock();
         }
         public void setPropertyValue(Object o, Object value)
         {
           ((XSDElementDeclaration)o).setStringBlock((String)value);
         }
         public Collection getChoiceOfValues(Object o)
         {
           Collection result = new ArrayList();
           result.add("");
           result.add("#all");
           result.add("extension");
           result.add("restriction");
           result.add("substitution");
           result.add("extension restriction");
           result.add("extension restriction substitution");
           result.add("extension substitution");
           result.add("restriction substitution");
           return result;
         }
       });
  }

  protected void createTargetNamespacePropertyDescriptor(Object object)
  {

    // This is for the name feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_TargetNamespace_label"),
         XSDEditPlugin.getString("_UI_TargetNamespace_description"),
         xsdPackage.getXSDNamedComponent_TargetNamespace(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public void setPropertyValue(Object o, Object value)
         {
           XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)o;
           if (xsdElementDeclaration.isElementDeclarationReference())
           {
             String namespace = (String)value;
             if (namespace.length() == 0)
             {
               namespace = null;
             }
             XSDElementDeclaration newResolvedElementDeclaration = 
               xsdElementDeclaration.resolveElementDeclaration(namespace, xsdElementDeclaration.getName());
             EditingDomain editingDomain = getEditingDomain(xsdElementDeclaration);
             if (editingDomain == null)
             {
               xsdElementDeclaration.setResolvedElementDeclaration(newResolvedElementDeclaration);
             }
             else
             {
               editingDomain.getCommandStack().execute
                 (SetCommand.create
                    (editingDomain, 
                     xsdElementDeclaration, 
                     xsdPackage.getXSDElementDeclaration_ResolvedElementDeclaration(), 
                     newResolvedElementDeclaration));
             }
           }
           else
           {
             super.setPropertyValue(o, value);
           }
         }
       });
  }

  protected void createElementFormDefaultPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)object;

    // This is for the elementFormDefault feature.
    //
    itemPropertyDescriptors.add
      (new XSDItemProviderAdapter.ItemPropertyDescriptorWithDefault
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Form_label"),
         XSDEditPlugin.getString("_UI_FormOfElement_description"),
         xsdPackage.getXSDFeature_Form(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return 
             XSDEditPlugin.getString
               ("_UI_DefaultValue_label", new Object [] { ((XSDElementDeclaration)o).getSchema().getElementFormDefault().getName() });
         }
       });
  }

  protected void createLexicalValuePropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the value feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_LexicalValue_label"),
         XSDEditPlugin.getString("_UI_LexicalValueOfElement_description"),
         xsdPackage.getXSDFeature_LexicalValue(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE));
  }

  protected void createConstraintPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the constraint feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Constraint_label"),
         XSDEditPlugin.getString("_UI_ConstraintOfElement_description"),
         xsdPackage.getXSDFeature_Constraint(),
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE));
  }

  protected void createScopePropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the scope feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Scope_label"),
         XSDEditPlugin.getString("_UI_ScopeOfElement_description"),
         xsdPackage.getXSDFeature_Scope(),
         false,
         null));
  }

  protected void createNillablePropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the nillable feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Nillable_label"),
         XSDEditPlugin.getString("_UI_Nillable_description"),
         xsdPackage.getXSDElementDeclaration_Nillable(),
         true,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
         }

         public Collection getChoiceOfValues(Object o)
         {
           return 
             Arrays.asList
               (new Object [] 
                { new Boolean(false), 
                  new Boolean(true), 
                  XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" }) 
                });
         }
       });
  }

  protected void createDisallowedSubstitutionsPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the disallowedSubstitutions feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_DisallowedSubstitutions_label"),
         XSDEditPlugin.getString("_UI_DisallowedSubstitutions_description"),
         xsdPackage.getXSDElementDeclaration_DisallowedSubstitutions(),
         false,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyValue(Object o)
         {
           return ((XSDElementDeclaration)o).getStringDisallowedSubstitutions();
         }
       });
  }

  protected void createSubstitutionGroupExclusionsPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the substitutionGroupExclusions feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_SubstitutionGroupExclusions_label"),
         XSDEditPlugin.getString("_UI_SubstitutionGroupExclusions_description"),
         xsdPackage.getXSDElementDeclaration_SubstitutionGroupExclusions(),
         false,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyValue(Object o)
         {
           return ((XSDElementDeclaration)o).getStringSubstitutionGroupExclusions();
         }
       });
  }

  protected void createAbstractPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the abstract feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Abstract_label"),
         XSDEditPlugin.getString("_UI_AbstractOfElement_description"),
         xsdPackage.getXSDElementDeclaration_Abstract(),
         true,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
         }

         public Collection getChoiceOfValues(Object o)
         {
           return 
             Arrays.asList
               (new Object [] 
                { new Boolean(false), 
                  new Boolean(true), 
                  XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" }) 
                });
         }
       });
  }

  protected void createTypeDefinitionPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the typeDefinition feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_TypeDefinition_label"),
         XSDEditPlugin.getString("_UI_TypeDefinitionOfElement_description"),
         xsdPackage.getXSDElementDeclaration_TypeDefinition(), 
         false,
         null));
  }

  protected void createSubstitutionGroupAffiliationPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the substitutionGroupAffiliation feature.
    //
    itemPropertyDescriptors.add
      (new DelegatingItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_SubstitutionGroupAffiliation_label"),
         XSDEditPlugin.getString("_UI_SubstitutionGroupAffiliation_description"),
         xsdPackage.getXSDElementDeclaration_SubstitutionGroupAffiliation(), 
         false,
         null));
  }

  protected void createAnnotationPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the annotation feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Annotation_label"),
         XSDEditPlugin.getString("_UI_AnnotationOfElement_description"),
         xsdPackage.getXSDElementDeclaration_Annotation(), 
         false));
  }

  protected void createResolvedElementDeclarationPropertyDescriptor(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);

    // This is for the resolvedElementDeclaration feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_ResolveElementDeclaration_label"),
         XSDEditPlugin.getString("_UI_ResolveElementDeclaration_description"),
         xsdPackage.getXSDElementDeclaration_ResolvedElementDeclaration(), 
         false));
  }

  /**
   * This specifies how to implement {@link #getChildren} and 
   * {@link org.eclipse.emf.edit.command.AddCommand} and 
   * {@link org.eclipse.emf.edit.command.RemoveCommand} support in {@link #createCommand}.
   */
  public Collection getChildrenReferences(Object object)
  {
    if (childrenReferences == null)
    {
      super.getChildrenReferences(object);
      XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);
      childrenReferences.add(xsdPackage.getXSDElementDeclaration_Annotation());
      childrenReferences.add(xsdPackage.getXSDElementDeclaration_AnonymousTypeDefinition());
      childrenReferences.add(xsdPackage.getXSDElementDeclaration_IdentityConstraintDefinitions());
    }
    return childrenReferences;
  }

  /**
   * This returns XSDElementDeclaration.gif.
   */
  public Object getImage(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);
    XSDElementDeclaration resolvedElementDeclaration = xsdElementDeclaration.getResolvedElementDeclaration();
    return 
      XSDEditPlugin.getImage
        (resolvedElementDeclaration.getContainer() == null ?
           "full/obj16/XSDElementUnresolved" :
           xsdElementDeclaration.getResolvedElementDeclaration() == xsdElementDeclaration ?
             "full/obj16/XSDElementDeclaration" :
             "full/obj16/XSDElementUse");
  }

  public String getText(Object object)
  {
    XSDElementDeclaration xsdElementDeclaration = ((XSDElementDeclaration)object);
    XSDElementDeclaration resolvedElementDeclaration = xsdElementDeclaration.getResolvedElementDeclaration();
    String name = 
      xsdElementDeclaration != resolvedElementDeclaration ?
        xsdElementDeclaration.getQName() :
        xsdElementDeclaration.getName();

    StringBuffer result = new StringBuffer();
    if (name == null)
    {
      result.append(XSDEditPlugin.getString("_UI_Absent_label"));
    }
    else
    {
      result.append(name);
    }

    if (resolvedElementDeclaration.getAnonymousTypeDefinition() == null && resolvedElementDeclaration.getTypeDefinition() != null)
    {
      result.append(" : ");
      result.append(resolvedElementDeclaration.getTypeDefinition().getQName(xsdElementDeclaration));
    }

    return result.toString();
  }

  /**
   * This handles notification by calling {@link #fireNotifyChanged fireNotifyChanged}.
   */
  public void notifyChanged(Notification msg) 
  {
    XSDElementDeclaration xsdElementDeclaration = (XSDElementDeclaration)msg.getNotifier();
    if (
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_Nillable() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_DisallowedSubstitutions() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_SubstitutionGroupAffiliation() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_SubstitutionGroupExclusions() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_Abstract() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_IdentityConstraintDefinitions() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_TypeDefinition() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_AnonymousTypeDefinition() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_SubstitutionGroupAffiliation() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_ResolvedElementDeclaration() || 
         msg.getFeature() == xsdPackage.getXSDElementDeclaration_Annotation()
       )
    {
      fireNotifyChanged(msg);
      XSDConcreteComponent container = xsdElementDeclaration.getContainer();
      if (container instanceof XSDParticle)
      {
        ((ItemProviderAdapter)adapterFactory.adapt(container, IItemLabelProvider.class)).fireNotifyChanged
          (new ENotificationImpl
            ((InternalEObject)container, 
             msg.getEventType(), 
             (EStructuralFeature)msg.getFeature(), 
             msg.getOldValue(), 
             msg.getNewValue(), 
             msg.getPosition()));
      }
      return;
    }
    super.notifyChanged(msg);
  }

  /**
   * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s 
   * describing all of the children that can be created under this object.
   */
  protected void collectNewChildDescriptors(Collection newChildDescriptors,
                                            Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
    XSDElementDeclaration ed = (XSDElementDeclaration) object;

    if (!ed.isElementDeclarationReference())
    {
      // annotation
      newChildDescriptors.add(createChildParameter(xsdPackage.getXSDElementDeclaration_Annotation(), xsdFactory.createXSDAnnotation()));

      // atomic, list, and union simple type definitions
      addSimpleTypeDefinitionChildParameters(newChildDescriptors, ed, xsdPackage.getXSDElementDeclaration_AnonymousTypeDefinition(), true, true, true);

      // complex type definition
      newChildDescriptors.add(createChildParameter(xsdPackage.getXSDElementDeclaration_AnonymousTypeDefinition(), createComplexTypeDefinition(ed)));

      // unique identity constraint definition
      XSDIdentityConstraintDefinition icd =
        createIdentityConstraintDefinition(ed);
      icd.setIdentityConstraintCategory(XSDIdentityConstraintCategory.UNIQUE_LITERAL);
      newChildDescriptors.add(createChildParameter(xsdPackage.getXSDElementDeclaration_IdentityConstraintDefinitions(), icd));

      // key identity constraint definition
      icd = createIdentityConstraintDefinition(ed);
      icd.setIdentityConstraintCategory(XSDIdentityConstraintCategory.KEY_LITERAL);
      newChildDescriptors.add(createChildParameter(xsdPackage.getXSDElementDeclaration_IdentityConstraintDefinitions(), icd));
      
      // keyref identity constraint definition
      XSDIdentityConstraintDefinition icdRef = xsdFactory.createXSDIdentityConstraintDefinition();
      icdRef.setIdentityConstraintCategory(XSDIdentityConstraintCategory.KEYREF_LITERAL);
      icdRef.setName(icd.getName());
      if (icd.getTargetNamespace() != null)
      {
        icdRef.setTargetNamespace(icd.getTargetNamespace());
      }
      icd = ed.resolveIdentityConstraintDefinition("");
      icdRef.setReferencedKey(icd);
      newChildDescriptors.add(createChildParameter(xsdPackage.getXSDElementDeclaration_IdentityConstraintDefinitions(), icdRef));
    }
  }
}