package terms;

import bytecodes.ByteCode; 

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);
}
