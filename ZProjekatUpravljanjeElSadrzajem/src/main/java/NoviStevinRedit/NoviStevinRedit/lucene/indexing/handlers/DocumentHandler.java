package NoviStevinRedit.NoviStevinRedit.lucene.indexing.handlers;

import NoviStevinRedit.NoviStevinRedit.ModelElastic.ObjavaEl;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ZajednicaEl;

import java.io.File;

public abstract class DocumentHandler {
    public abstract ZajednicaEl getIndexUnitCommunity(File file);
    public abstract ObjavaEl getIndexUnitPost(File file);
    public abstract String getText(File file);
}
