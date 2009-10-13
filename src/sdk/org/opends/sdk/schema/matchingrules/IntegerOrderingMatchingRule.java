package org.opends.sdk.schema.matchingrules;

import org.opends.sdk.DecodeException;
import org.opends.sdk.util.StaticUtils;
import org.opends.sdk.schema.Schema;
import org.opends.server.types.ByteSequence;
import org.opends.server.types.ByteString;
import org.opends.messages.Message;
import static org.opends.messages.SchemaMessages.WARN_ATTR_SYNTAX_ILLEGAL_INTEGER;

/**
 * This class defines the integerOrderingMatch matching rule defined in X.520
 * and referenced in RFC 4519.
 */
public class IntegerOrderingMatchingRule
    extends AbstractOrderingMatchingRuleImplementation
{

  public ByteString normalizeAttributeValue(Schema schema, ByteSequence value)
      throws DecodeException
  {
    try
    {
      return ByteString.valueOf(
          Integer.parseInt(value.toString()));
    }
    catch (Exception e)
    {
      StaticUtils.DEBUG_LOG.throwing(
            "IntegerOrderingMatchingRule",  "normalizeAttributeValue", e);

      Message message = WARN_ATTR_SYNTAX_ILLEGAL_INTEGER.get(value.toString());
      throw new DecodeException(message);
    }
  }
}
