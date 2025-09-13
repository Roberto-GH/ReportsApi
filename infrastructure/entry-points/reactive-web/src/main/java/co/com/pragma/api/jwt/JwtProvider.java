package co.com.pragma.api.jwt;

import co.com.pragma.api.constants.ReportsWebKeys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.logging.Logger;

@Component
public class JwtProvider {

  private static final Logger LOG = Logger.getLogger(JwtProvider.class.getName());

  private final String secret;

  public JwtProvider(@Value("${jwt.secret}") String secret) {
    this.secret = secret;
  }

  public Claims getClaims(String token) {
    validate(token);
    return Jwts.parser().verifyWith(getKey(secret)).build().parseSignedClaims(token).getPayload();
  }

  public void validate(String token) {
    try {
      Jwts.parser().verifyWith(getKey(secret)).build().parseSignedClaims(token).getPayload().getSubject();
    } catch (ExpiredJwtException e) {
      LOG.severe(ReportsWebKeys.TOKEN_EXPIRED);
    } catch (MalformedJwtException e) {
      LOG.severe(ReportsWebKeys.TOKEN_MALFORMED);
    } catch (SignatureException e) {
      LOG.severe(ReportsWebKeys.BAD_SIGNATURE);
    } catch (IllegalArgumentException e) {
      LOG.severe(ReportsWebKeys.ILLEGAL_ARGS);
    }
  }

  private SecretKey getKey(String secret) {
    byte[] secretBytes = Decoders.BASE64URL.decode(secret);
    return Keys.hmacShaKeyFor(secretBytes);
  }

}
