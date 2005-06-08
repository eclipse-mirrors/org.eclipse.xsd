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
 * $Id: XSDSimpleTypeDefinitionItemProvider.java,v 1.2.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import org.eclipse.xsd.XSDBoundedFacet;
import org.eclipse.xsd.XSDCardinalityFacet;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConstrainingFacet;
import org.eclipse.xsd.XSDDerivationMethod;
import org.eclipse.xsd.XSDFractionDigitsFacet;
import org.eclipse.xsd.XSDFundamentalFacet;
import org.eclipse.xsd.XSDLengthFacet;
import org.eclipse.xsd.XSDMaxExclusiveFacet;
import org.eclipse.xsd.XSDMaxInclusiveFacet;
import org.eclipse.xsd.XSDMaxLengthFacet;
import org.eclipse.xsd.XSDMinExclusiveFacet;
import org.eclipse.xsd.XSDMinInclusiveFacet;
import org.eclipse.xsd.XSDMinLengthFacet;
import org.eclipse.xsd.XSDNumericFacet;
import org.eclipse.xsd.XSDOrderedFacet;
import org.eclipse.xsd.XSDRepeatableFacet;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTotalDigitsFacet;
import org.eclipse.xsd.XSDVariety;
import org.eclipse.xsd.XSDWhiteSpaceFacet;
import org.eclipse.xsd.util.XSDConstants;


/**
 * This is the item provider adpater for a {@link org.eclipse.xsd.XSDSimpleTypeDefinition} object.
 */
public class XSDSimpleTypeDefinitionItemProvider
  extends XSDTypeDefinitionItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   */
  public XSDSimpleTypeDefinitionItemProvider(AdapterFactory adapterFactory)
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

      XSDSimpleTypeDefinition xsdSimpleTypeDefinition = ((XSDSimpleTypeDefinition)object);

      // This is for the annotation feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Annotation_label"),
           XSDEditPlugin.getString("_UI_AnnotationOfType_description"),
           xsdPackage.getXSDTypeDefinition_Annotation(), 
           false));

      // This is for the ordered facet.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Ordered_label"),
           XSDEditPlugin.getString("_UI_Ordered_description"),
           xsdPackage.getXSDTypeDefinition_Annotation(), 
           false,
           ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
         {
           public Object getPropertyValue(Object o)
           {
             XSDSimpleTypeDefinition simpleTypeDefinition = (XSDSimpleTypeDefinition)o;
             for (Iterator fundamentalFacets = simpleTypeDefinition.getFundamentalFacets().iterator(); fundamentalFacets.hasNext(); )
             {
               XSDFundamentalFacet xsdFundamentalFacet = (XSDFundamentalFacet)fundamentalFacets.next();
               if (xsdFundamentalFacet instanceof XSDOrderedFacet)
               {
                 return ((XSDOrderedFacet)xsdFundamentalFacet).getValue().getName();
               }
             }
             return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
           }
         });

      // This is for the cardinality facet.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Cardinality_label"),
           XSDEditPlugin.getString("_UI_Cardinality_description"),
           xsdPackage.getXSDTypeDefinition_Annotation(), 
           false,
           ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
         {
           public Object getPropertyValue(Object o)
           {
             XSDSimpleTypeDefinition simpleTypeDefinition = (XSDSimpleTypeDefinition)o;
             for (Iterator fundamentalFacets = simpleTypeDefinition.getFundamentalFacets().iterator(); fundamentalFacets.hasNext(); )
             {
               XSDFundamentalFacet xsdFundamentalFacet = (XSDFundamentalFacet)fundamentalFacets.next();
               if (xsdFundamentalFacet instanceof XSDCardinalityFacet)
               {
                 String result = ((XSDCardinalityFacet)xsdFundamentalFacet).getValue().getName();
                 if ("countablyInfinite".equals(result))
                 {
                   result = "countably infinite";
                 }
                 return result;
               }
             }
             return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
           }
         });

      // This is for the bounded facet.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Bounded_label"),
           XSDEditPlugin.getString("_UI_Bounded_description"),
           xsdPackage.getXSDTypeDefinition_Annotation(), 
           false,
           ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
         {
           public Object getPropertyValue(Object o)
           {
             XSDSimpleTypeDefinition simpleTypeDefinition = (XSDSimpleTypeDefinition)o;
             for (Iterator fundamentalFacets = simpleTypeDefinition.getFundamentalFacets().iterator(); fundamentalFacets.hasNext(); )
             {
               XSDFundamentalFacet xsdFundamentalFacet = (XSDFundamentalFacet)fundamentalFacets.next();
               if (xsdFundamentalFacet instanceof XSDBoundedFacet)
               {
                 return ((XSDBoundedFacet)xsdFundamentalFacet).isValue() ? "true" : "false";
               }
             }
             return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
           }
         });

      // This is for the numeric facet.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Numeric_label"),
           XSDEditPlugin.getString("_UI_Numeric_description"),
           xsdPackage.getXSDTypeDefinition_Annotation(), 
           false,
           ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
         {
           public Object getPropertyValue(Object o)
           {
             XSDSimpleTypeDefinition simpleTypeDefinition = (XSDSimpleTypeDefinition)o;
             for (Iterator fundamentalFacets = simpleTypeDefinition.getFundamentalFacets().iterator(); fundamentalFacets.hasNext(); )
             {
               XSDFundamentalFacet xsdFundamentalFacet = (XSDFundamentalFacet)fundamentalFacets.next();
               if (xsdFundamentalFacet instanceof XSDNumericFacet)
               {
                 return ((XSDNumericFacet)xsdFundamentalFacet).isValue() ? "true" : "false";
               }
             }
             return XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { "false" });
           }
         });
      // This is for the baseTypeDefinition feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_BaseTypeDefinition_label"),
           XSDEditPlugin.getString("_UI_BaseTypeDefinition_description"),
           xsdPackage.getXSDSimpleTypeDefinition_BaseTypeDefinition(), 
           false));

      // This is for the itemTypeDefinition feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_ItemTypeDefinition_label"),
           XSDEditPlugin.getString("_UI_ItemTypeDefinition_description"),
           xsdPackage.getXSDSimpleTypeDefinition_ItemTypeDefinition(), 
           false));

      // This is for the variety feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Variety_label"),
           XSDEditPlugin.getString("_UI_Variety_description"),
           xsdPackage.getXSDSimpleTypeDefinition_Variety(), 
           false)
         {
           public Object getPropertyValue(Object o)
           {
             if (((XSDSimpleTypeDefinition)o).isSetVariety())
             {
               return super.getPropertyValue(o);
             }
             else
             {
               return XSDEditPlugin.getString("_UI_Absent_label");
             }
           }
         });

      // This is for the primitive type definition feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_PrimitiveTypeDefinition_label"),
           XSDEditPlugin.getString("_UI_PrimitiveTypeDefinition_description"),
           xsdPackage.getXSDSimpleTypeDefinition_PrimitiveTypeDefinition(), 
           false));

      createLexicalFinalPropertyDescriptor(object);
      createFinalPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }


  protected void createLexicalFinalPropertyDescriptor(Object object)
  {

    // This is for the final feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptorWithDefault
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_LexicalFinal_label"),
         XSDEditPlugin.getString("_UI_LexicalFinal_description"),
         xsdPackage.getXSDSimpleTypeDefinition_LexicalFinal(), 
         true,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyDefaultValue(Object o)
         {
           return 
             XSDEditPlugin.getString("_UI_DefaultValue_label", new Object [] { ((XSDSimpleTypeDefinition)o).getStringLexicalFinal() });
         }
         public Object getPropertyValue(Object o)
         {
           return ((XSDSimpleTypeDefinition)o).getStringLexicalFinal();
         }
         public void setPropertyValue(Object o, Object value)
         {
           ((XSDSimpleTypeDefinition)o).setStringLexicalFinal((String)value);
         }
         public Collection getChoiceOfValues(Object o)
         {
           Collection result = new ArrayList();
           result.add("");
           result.add("#all");
           result.add("restriction");
           result.add("restriction list");
           result.add("restriction list union");
           result.add("restriction union");
           result.add("list");
           result.add("list union");
           result.add("union");
           return result;
         }
       });
  }

  protected void createFinalPropertyDescriptor(Object object)
  {

    // This is for the final feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptorWithDefault
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_Final_label"),
         XSDEditPlugin.getString("_UI_FinalOfType_description"),
         xsdPackage.getXSDSimpleTypeDefinition_Final(), 
         false,
         ItemPropertyDescriptor.TEXT_VALUE_IMAGE)
       {
         public Object getPropertyValue(Object o)
         {
           return ((XSDSimpleTypeDefinition)o).getStringFinal();
         }
       });
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   */
  public Collection getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      XSDSimpleTypeDefinition xsdSimpleTypeDefinition = ((XSDSimpleTypeDefinition)object);
      childrenFeatures.add(xsdPackage.getXSDTypeDefinition_Annotation());
      childrenFeatures.add(xsdPackage.getXSDTypeDefinition_DerivationAnnotation());
      childrenFeatures.add(xsdPackage.getXSDSimpleTypeDefinition_Contents());
      childrenFeatures.add(xsdPackage.getXSDSimpleTypeDefinition_FacetContents());
    }
    return childrenFeatures;
  }

  /**
   * This returns XSDSimpleTypeDefinition.gif.
   */
  public Object getImage(Object object)
  {
    XSDSimpleTypeDefinition xsdSimpleTypeDefinition = ((XSDSimpleTypeDefinition)object);
    return 
      XSDEditPlugin.getImage
        (xsdSimpleTypeDefinition.getContainer() == null ?
           "full/obj16/XSDSimpleTypeDefinitionUnresolved" :
           XSDVariety.LIST_LITERAL == xsdSimpleTypeDefinition.getVariety() ? 
             "full/obj16/XSDSimpleTypeDefinitionList" :  
              XSDVariety.UNION_LITERAL == xsdSimpleTypeDefinition.getVariety() ? 
                "full/obj16/XSDSimpleTypeDefinitionUnion" :
                  xsdSimpleTypeDefinition.isSetVariety() ?
                    "full/obj16/XSDSimpleTypeDefinitionAtomic"  :
                    "full/obj16/XSDSimpleTypeDefinition");
  }

  public String getText(Object object)
  {
    return getText(object, true);
  }

  public String getText(Object object, boolean showType)
  {
    XSDSimpleTypeDefinition xsdSimpleTypeDefinition = ((XSDSimpleTypeDefinition)object);

    StringBuffer result = new StringBuffer();

    result.append
      (xsdSimpleTypeDefinition.getName() == null ? 
         xsdSimpleTypeDefinition.getAliasName() :
         xsdSimpleTypeDefinition.getName());

    if (showType)
    {
      XSDSimpleTypeDefinition baseTypeDefinition = xsdSimpleTypeDefinition.getBaseTypeDefinition();
      if (baseTypeDefinition != null && XSDVariety.ATOMIC_LITERAL == xsdSimpleTypeDefinition.getVariety())
      {
        if (baseTypeDefinition.getName() != null && 
              !xsdSimpleTypeDefinition.getContents().contains(baseTypeDefinition) &&
              !XSDConstants.isAnySimpleType(baseTypeDefinition)) 
        {
          result.append(" : ");
          result.append(baseTypeDefinition.getQName(xsdSimpleTypeDefinition));
        }
      }
      else
      {
        XSDSimpleTypeDefinition itemTypeDefinition = xsdSimpleTypeDefinition.getItemTypeDefinition();
        if (itemTypeDefinition != null)
        {
          if (itemTypeDefinition.getName() != null) 
          {
            result.append(" : ");
            result.append(itemTypeDefinition.getQName());
          }
        }
        else 
        {
          List memberTypeDefinitions = xsdSimpleTypeDefinition.getMemberTypeDefinitions();
          if (!memberTypeDefinitions.isEmpty())
          {
            boolean first = true;
            for (Iterator members = memberTypeDefinitions.iterator(); members.hasNext(); )
            {
              XSDSimpleTypeDefinition memberTypeDefinition = (XSDSimpleTypeDefinition)members.next();
              if (memberTypeDefinition.getName() != null) 
              {
                if (first)
                {
                  result.append(" : ");
                  first = false;
                }
                else
                {
                  result.append(" | ");
                }
                result.append(memberTypeDefinition.getQName());
              }
              else
              {
                break;
              }
            }
          } 
          else if (result.length() == 0)
          {
            result.append(XSDEditPlugin.getString("_UI_Absent_label"));
          }
        }
      }
    }

    return result.toString();
  }

  /**
   * This handles notification by calling {@link #fireNotifyChanged fireNotifyChanged}.
   */
  public void notifyChanged(Notification msg) 
  {
    if (msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_FacetContents() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_Contents() || 
          msg.getFeature() == xsdPackage.getXSDTypeDefinition_Annotation() || 
          msg.getFeature() == xsdPackage.getXSDTypeDefinition_DerivationAnnotation() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_Variety() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_LexicalFinal() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_Final() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_ItemTypeDefinition() || 
          msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_BaseTypeDefinition())
    {
      fireNotifyChanged(msg);
      return;
    }
    else if (msg.getFeature() == xsdPackage.getXSDSimpleTypeDefinition_MemberTypeDefinitions())
    {
      fireNotifyChanged
        (new ENotificationImpl((InternalEObject)msg.getNotifier(), Notification.SET, null, null, null, Notification.NO_INDEX));
      return;
    }
    super.notifyChanged(msg);
  }

  /**
   * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s 
   * describing all of the children that can be created under this object.  
   * The allowable simple type definition and facet children depend upon the 
   * variety and (if atomic) the primitive type of this simple type definition, 
   * as well as upon its existing children.  For an option to be displayed, but
   * disabled, {@link org.eclipse.emf.edit.command.CommandParameter#feature} 
   * is <code>null</code>.
   */
  protected void collectNewChildDescriptors(Collection newChildDescriptors,
                                            Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
    XSDSimpleTypeDefinition std = (XSDSimpleTypeDefinition) object;

    // type annotation
    newChildDescriptors.add(createChildParameter(xsdPackage.getXSDTypeDefinition_Annotation(), xsdFactory.createXSDAnnotation()));

    // derivation annotation
    newChildDescriptors.add(createChildParameter(xsdPackage.getXSDTypeDefinition_DerivationAnnotation(), xsdFactory.createXSDAnnotation()));

    // children for simple type derivation, except on simple type definition
    // content of a complex type definition with extension derivation
    // method...
    if (!(std.eContainer() instanceof XSDComplexTypeDefinition) ||
        ((XSDComplexTypeDefinition) std.eContainer()).getDerivationMethod() != XSDDerivationMethod.EXTENSION_LITERAL)
    {
      boolean isAtomic = std.getVariety() == XSDVariety.ATOMIC_LITERAL;
      boolean isList = std.getVariety() == XSDVariety.LIST_LITERAL;
      boolean isUnion = std.getVariety() == XSDVariety.UNION_LITERAL;
      Collection validFacets = std.getValidFacets();

      // anonymous simple type definition(s) for derivation (single-valued
      // for non-list varieties)
      EReference feature = !isUnion && !std.getContents().isEmpty() ?
        null : xsdPackage.getXSDSimpleTypeDefinition_Contents();
      addSimpleTypeDefinitionChildParameters(newChildDescriptors, std, feature,
                                             true, isUnion, !isAtomic);
      // facets
      for (Iterator i = validFacets.iterator(); i.hasNext(); )
      {
        XSDConstrainingFacet facet =
          (XSDConstrainingFacet)xsdFactory.create((EClass)xsdPackage.getEClassifier(formFacetTypeName(i.next())));
        facet.setLexicalValue("");
        feature = !canAccomodateFacet(std, facet) ? null :
          xsdPackage.getXSDSimpleTypeDefinition_FacetContents();
        newChildDescriptors.add(createChildParameter(feature, facet));
      }
    }
  }

  /**
   * This forms the name for a facet MOF type, from the string (with
   * <code>Object</code> static type) obtained from the collection returned
   * by {@link XSDSimpleTypeDefinition#getValidFacets}.  The object is
   * cast to a <code>String</code>, the first character is capitalized,
   * "XSD" is prepended, and "Facet" appended.
   */
  protected String formFacetTypeName(Object facetName)
  {
    StringBuffer buffer = new StringBuffer((String) facetName);
    char c = buffer.charAt(0);
    buffer.setCharAt(0, Character.toUpperCase(c));
    buffer.insert(0, "XSD");
    buffer.append("Facet");
    return buffer.toString();
  }

  /**
   * This tests whether the specified simple type definition,
   * <code>s</code>, can accomodate the given constraining facet,
   * <code>f</code>, based on its existing facet children.
   */
  protected boolean canAccomodateFacet(XSDSimpleTypeDefinition s,
                                       XSDConstrainingFacet f)
  {
    return
      (f instanceof XSDRepeatableFacet) ||
      (f instanceof XSDLengthFacet && s.getLengthFacet() == null &&
       s.getMinLengthFacet() == null && s.getMaxLengthFacet() == null) ||
      (f instanceof XSDMinLengthFacet && s.getMinLengthFacet() == null &&
        s.getLengthFacet() == null) ||
      (f instanceof XSDMaxLengthFacet && s.getMaxLengthFacet() == null &&
        s.getLengthFacet() == null) ||
      (f instanceof XSDWhiteSpaceFacet && s.getWhiteSpaceFacet() == null) ||
      (f instanceof XSDMinInclusiveFacet && s.getMinFacet() == null) ||
      (f instanceof XSDMinExclusiveFacet && s.getMinFacet() == null) ||
      (f instanceof XSDMaxInclusiveFacet && s.getMaxFacet() == null) ||
      (f instanceof XSDMaxExclusiveFacet && s.getMaxFacet() == null) ||
      (f instanceof XSDTotalDigitsFacet && s.getTotalDigitsFacet() == null) ||
      (f instanceof XSDFractionDigitsFacet 
       && s.getFractionDigitsFacet() == null);
  }
}
