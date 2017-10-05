package com.aliya.constraint.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * xml布局 TextView
 *
 * @author a_liYa
 * @date 2017/10/2 15:10.
 */
public class XmlTextView extends android.support.v7.widget.AppCompatTextView {

    public XmlTextView(Context context) {
        super(context);
    }

    public XmlTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public XmlTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        StringBuffer xmlSB = new StringBuffer();
        xmlSB.append("<" + getClass().getSimpleName());
        final int N = attrs.getAttributeCount();
        for (int i = 0; i < N; i++) {
            String attrName = attrs.getAttributeName(i);
            String attrVal = attrs.getAttributeValue(i);
            xmlSB.append("\n    ")
                    .append(attrName)
                    .append("=")
                    .append("\"")
                    .append(adapterVal(attrName, attrVal))
                    .append("\"");
        }
        xmlSB.append(" />");
        setText(xmlSB.toString());
    }

    private String adapterVal(String attrName, String attrVal) {
        if ("layout_width".equals(attrName) || "layout_height".equals(attrName)) {
            if ("-2".equals(attrVal)) {
                return "wrap_content";
            } else if ("-1".equals(attrVal)) {
                return "match_parent";
            }
        } else if (attrName.startsWith("layout_constraint")) {
            if ("0".equals(attrVal)) {
                return "parent";
            }
        }

        if (attrVal.startsWith("@")) {
            String subStr = attrVal.substring(1, attrVal.length());
            try {
                Integer id = Integer.valueOf(subStr);
                Log.e("TAG", "PackageName " + getResources().getResourcePackageName(id));
                Log.e("TAG", "Name " + getResources().getResourceName(id));
                String typeName = getResources().getResourceTypeName(id);
                return "@" + typeName + "/" + getResources().getResourceEntryName(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return attrVal;
    }

}
